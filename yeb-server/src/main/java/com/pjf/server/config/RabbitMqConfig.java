package com.pjf.server.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.pjf.server.entity.MailConstants;
import com.pjf.server.entity.MailLog;
import com.pjf.server.service.IMailLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


/**
 * @author pjf
 * @Date 2022/1/13 10:15
 * rabbitmq配置类
 **/
@Slf4j
@Configuration
public class RabbitMqConfig {

    @Resource
    private CachingConnectionFactory cachingConnectionFactory;
    @Resource
    private IMailLogService mailLogService;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        //确认消息回调，确认消息是否到达broker data唯一标识，ack确认结果 cause失败原因
        rabbitTemplate.setConfirmCallback((data, ack, cause) -> {
            String msgId = data.getId();
            if (ack) {
                log.info("{}======》消息发送成功", msgId);
                mailLogService.update(new UpdateWrapper<MailLog>().set("status", 1).eq("msgId", msgId));
            } else {
                log.error("{}======》消息发送失败", msgId);
            }
        });
        //消息失败回调 msg消息主题 repCode响应码 repText响应描述 exchange交换机  routingKey路由键
        rabbitTemplate.setReturnCallback((msg, repCode, repText, exchange, routingKey) -> {
            log.error("{}======》消息发送queue失败", msg.getBody());
        });
        return rabbitTemplate;
    }


    @Bean
    public Queue queue() {
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(MailConstants.MAIL_EXCHANGE_NAME);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(MailConstants.MAIL_ROUTING_KEY_NAME);
    }

}
