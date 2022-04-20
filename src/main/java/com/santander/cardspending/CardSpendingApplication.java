package com.santander.cardspending;

import com.santander.cardspending.domain.Launch;
import com.santander.cardspending.repositories.LaunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class CardSpendingApplication {

	@Autowired
	private LaunchRepository launchRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardSpendingApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		Launch launch1 = new Launch(null,"Pedro","Almoço",,new BigDecimal("10.00"),"Tag 1 almoço");
//		Launch launch2 = new Launch(null,"Nicole","Jantar",null,new BigDecimal("20.00"),"Tag 2 jantar");
//
//		launchRepository.saveAll(Arrays.asList(launch1,launch2));
//
//	}
}
