package com.pjf.server.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.pjf.server.entity.Employee;
import com.pjf.server.entity.MailConstants;
import com.pjf.server.entity.MailLog;
import com.pjf.server.service.IEmployeeService;
import com.pjf.server.service.IMailLogService;
import org.apache.tomcat.jni.Local;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author pjf
 * @Date 2022/1/13 10:43
 * 邮件发送服务定时任务
 **/
@Component
public class MailTask {
    @Resource
    IMailLogService mailLogService;
    @Resource
    IEmployeeService employeeService;

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 邮件发送定时任务 十秒一次
     */
//    @Scheduled(cron = "0/10 * * * * ?")
    public void mailTask() {
        List<MailLog> list = mailLogService.list(new QueryWrapper<MailLog>().eq("status", 0).lt("tryTime", LocalDateTime.now()));
        list.forEach(mailLog -> {
            if (3 <= mailLog.getCount()) {
                mailLogService.update(new UpdateWrapper<MailLog>().set("status", 2).eq("msgId", mailLog.getMsgId()));
            }
            mailLogService.update(new UpdateWrapper<MailLog>()
                    .set("count", mailLog.getCount() + 1)
                    .set("updateTime", LocalDateTime.now())
                    .set("tryTime", LocalDateTime.now().plusMinutes(MailConstants.MSG_TIMEOUT))
                    .eq("msgId", mailLog.getMsgId())
            );
            Employee employee = employeeService.getEmployee(mailLog.getEid()).get(0);
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME,
                    employee, new CorrelationData(mailLog.getMsgId()));
        });
    }
}
