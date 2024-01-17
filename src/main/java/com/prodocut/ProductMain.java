package com.prodocut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ProductMain {
    public static void main(String[] args) {
        SpringApplication.run(ProductMain.class, args);
    }

}
