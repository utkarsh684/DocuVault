package com.example.DocuVault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DocuVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocuVaultApplication.class, args);
	}

}
