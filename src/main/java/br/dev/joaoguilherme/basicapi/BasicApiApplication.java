package br.dev.joaoguilherme.basicapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BasicApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApiApplication.class, args);
    }

}
