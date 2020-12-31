package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class EurekaApplication {

    public static void main(String[] args) {

        System.out.println(">>>>>>>>>>>>>>> 启动EurekaServer <<<<<<<<<<<<<<<");

        SpringApplication.run(EurekaApplication.class, args);

        System.out.println(">>>>>>>>>>>>>>> 运行EurekaServer成功 <<<<<<<<<<<<<<<");

    }

}
