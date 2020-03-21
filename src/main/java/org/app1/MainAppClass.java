package org.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"org.app2.*"})
public class MainAppClass {
    public static void main(String[] args) {
        SpringApplication.run(MainAppClass.class, args);
    }
}
