package com.ghani.bms;

import com.ghani.bms.service.InitializeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BmsApplication implements CommandLineRunner {

    @Autowired
    private InitializeService initializeService;
    public static void main(String[] args) {
        SpringApplication.run(BmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Initializing...data populating.....");
        initializeService.initialize();
        System.out.println("Initialization completed...");
    }
}
