package com.skilldistillery.pokemonbreeder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PokemonBreederApplication extends SpringBootServletInitializer {
	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(PokemonBreederApplication.class);
	  }
	public static void main(String[] args) {
		SpringApplication.run(PokemonBreederApplication.class, args);
	}

}
