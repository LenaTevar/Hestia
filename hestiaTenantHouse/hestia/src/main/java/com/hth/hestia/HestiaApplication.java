package com.hth.hestia;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class HestiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HestiaApplication.class, args);
		System.out.println("================ WELCOME TO HESTIA =============================");
		System.out.println("================ GO TO localhost:8080/ =========================");
		System.out.println("================ OR CHECK THE DB at /h2-console ================");
	}
	
	@Scheduled(fixedRate = 2000L)
	void someJob() {
		System.out.println("Now is " + new Date());
	}

}

