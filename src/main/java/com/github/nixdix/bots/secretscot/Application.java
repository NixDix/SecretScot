package com.github.nixdix.bots.secretscot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		Bot.runBot();
		SpringApplication.run(Application.class, args);
	}
}
