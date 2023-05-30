package com.mon.socket.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.mon.socket.server"
        }
)
public class ServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(
                ServerApplication.class,
                args
        );
    }

}