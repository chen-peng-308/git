package com.logistics.userdame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.logistics.userdame.dao")
@EnableScheduling//激活自动调度
public class UserdameApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserdameApplication.class, args);
    }

}
