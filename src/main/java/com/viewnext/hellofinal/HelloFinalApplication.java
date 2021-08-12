package com.viewnext.hellofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloFinalApplication.class, args);
	}

	@GetMapping("/")
	public String hello(@RequestParam(value = "saludo", defaultValue = "Un Saludo") String saludo) {
		return String.format("Muy buenas Javier! Gracias por esta formacion, eres un crack! %s!", saludo);
	}

}
