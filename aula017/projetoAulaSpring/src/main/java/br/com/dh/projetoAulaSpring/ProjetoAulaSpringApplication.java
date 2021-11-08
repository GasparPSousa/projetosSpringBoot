package br.com.dh.projetoAulaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class ProjetoAulaSpringApplication {


	@RequestMapping("/")
	String home() {
		return  "Nosso primeiro Spring";
	}


	public static void main(String[] args) {

		SpringApplication.run(ProjetoAulaSpringApplication.class, args);
	}



}
