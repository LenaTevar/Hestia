package com.hth.hestia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HestiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HestiaApplication.class, args);
		System.out.println("================ WELCOME TO HESTIA =============================");
		System.out.println("================ GO TO localhost:8080/ =========================");
		System.out.println("================ OR CHECK THE DB at /h2-console ================");
	}

}
