package br.com.ecommerce.mvc.bigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class EcommerceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
		System.out.println("Spring Framework carregado!");
		System.out.println("Spring Data carregado!");
	}

}
