package com.sudokubase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.sudokubase")
@EnableScheduling
public class DemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemaApplication.class, args);
               
	}
        
  


}
