package com.skilldistillery.pokemonbreeder.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.pokemonbreeder.entities.Pokemon;

public interface PokemonService {
	
	List<Pokemon> getAllPokemon();
	Pokemon addPokemon(Pokemon pokemon);
	void deletePokemon (int id);
	Optional<Pokemon> updatePokemon(int pokemonId, Optional<Pokemon> pokemon);
	Optional<Pokemon> findById(Integer id);

}
