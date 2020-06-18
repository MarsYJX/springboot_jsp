package com.xxx.springboot_jsp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.xxx.springboot_jsp.mapper")
public class SpringbootJspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJspApplication.class, args);
    }

}
