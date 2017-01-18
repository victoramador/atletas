package com.example;

import com.example.service.AtletaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AtletasApiApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AtletasApiApplication.class, args);

        AtletaService jugadorService = context.getBean(AtletaService.class);
        jugadorService.testAtletas();
	}
}