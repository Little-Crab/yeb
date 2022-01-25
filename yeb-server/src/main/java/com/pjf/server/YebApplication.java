package com.pjf.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author pjf
 * 类名：YebApplication
 * 创建时间: 2021/12/17 10:24.
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.pjf.server.mapper")
public class YebApplication {
    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class, args);
    }
}
