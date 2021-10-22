package com.skilldistillery.pokemonbreeder.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.pokemonbreeder.entities.Pokemon;
import com.skilldistillery.pokemonbreeder.services.PokemonService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4300" })
public class PokemonController {

	@Autowired
	private PokemonService pokemonSvc;

	@GetMapping("pokemon")
	public List<Pokemon> pokemonIndex() {
		return pokemonSvc.getAllPokemon();
	}
	
	

	@PostMapping("pokemon")
	public Pokemon addPokemon(
			@RequestBody Pokemon pokemon,
			HttpServletRequest req,
			HttpServletResponse res
			) {
		try {
			pokemonSvc.addPokemon(pokemon);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(pokemon.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
			pokemon = null;
		}
		return pokemon;
	}
	
	
	@GetMapping("pokemon/{id}")
	public Optional<Pokemon> showPokemon(
			@PathVariable Integer id,
			HttpServletResponse res) {
		Optional<Pokemon> pokemon = pokemonSvc.findById(id);
		if (pokemon == null) {
			res.setStatus(404);
		}
		return pokemon;
	}
	
	
	@PutMapping("pokemon/{id}")
	public Pokemon updatePokemon(
			@PathVariable Integer id,
			@RequestBody Pokemon pokemon,
			HttpServletResponse res) {
		try {
			pokemon = pokemonSvc.updatePokemon(id, pokemon);
			if (pokemon == null) {
				res.setStatus(400);
			}
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
			pokemon = null;
		} return pokemon;
	}
	
	
	@DeleteMapping("pokemon/{id}")
	public void deletePokemon(@PathVariable Integer id,
			HttpServletResponse res
			) {
			try {
				pokemonSvc.deletePokemon(id);
				res.setStatus(204);
			} catch (Exception e) {
				System.err.println(e);
				res.setStatus(400);
	}
	
}}