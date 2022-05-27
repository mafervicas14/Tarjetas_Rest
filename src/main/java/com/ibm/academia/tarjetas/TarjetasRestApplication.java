package com.ibm.academia.tarjetas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TarjetasRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarjetasRestApplication.class, args);
	}

}
