package org.example.equipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EquipesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipesApplication.class, args);
    }

}
