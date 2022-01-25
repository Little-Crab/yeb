package com.pjf.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author pjf
 * 类名：CodeGenerator
 * 创建时间: 2021/12/17 10:34.
 */
public class CodeGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1/yeb?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT%2B8&allowMultiQueries=true&useSSL=false&allowPublicKeyRetrieval=true", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("pjf") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.pjf.server") // 设置父包名
                            .mapper("mapper")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://src//main//resource//mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_admin_role") // 设置需要生成的表名
                            .addInclude("t_admin")
                            .addInclude("t_appraise")
                            .addInclude("t_department")
                            .addInclude("t_employee")
                            .addInclude("t_employee_ec")
                            .addInclude("t_employee_remove")
                            .addInclude("t_employee_train")
                            .addInclude("t_joblevel")
                            .addInclude("t_mail_log")
                            .addInclude("t_menu")
                            .addInclude("t_menu_role")
                            .addInclude("t_nation")
                            .addInclude("t_oplog")
                            .addInclude("t_politics_status")
                            .addInclude("t_position")
                            .addInclude("t_role")
                            .addInclude("t_salary")
                            .addInclude("t_salary_adjust")
                            .addInclude("t_sys_msg")
                            .addInclude("t_sys_msg_content")
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
