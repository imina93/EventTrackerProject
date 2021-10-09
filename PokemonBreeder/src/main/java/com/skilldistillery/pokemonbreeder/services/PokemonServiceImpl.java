package com.skilldistillery.pokemonbreeder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.pokemonbreeder.entities.Pokemon;
import com.skilldistillery.pokemonbreeder.repositories.PokemonRepository;

@Service
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	private PokemonRepository pokemonRepo;
	
	@Override
	public List<Pokemon> getAllPokemon() {
		return pokemonRepo.findAll();
	}

	@Override
	public Pokemon addPokemon(Pokemon pokemon) {
		
		return pokemonRepo.saveAndFlush(pokemon);
	}

	@Override
	public void deletePokemon(int id) {
		pokemonRepo.deleteById(id);
	}

}
