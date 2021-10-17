package com.skilldistillery.pokemonbreeder.services;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public Pokemon updatePokemon(int pokemonId, Pokemon pokemon) {
		Optional<Pokemon> ownedPokemon = pokemonRepo.findById(pokemonId);
		if (ownedPokemon.get() != null) {
			Pokemon savedPokemon = ownedPokemon.get();
			savedPokemon.setAbility(pokemon.getAbility());
			savedPokemon.setIvSpread(pokemon.getIvSpread());
			savedPokemon.setTrainer(pokemon.getTrainer());
			savedPokemon.setName(pokemon.getName());
			savedPokemon.setNotes(pokemon.getNotes());
			savedPokemon.setNature(pokemon.getNature());
			savedPokemon = pokemonRepo.saveAndFlush(savedPokemon);
			
			return savedPokemon;
			
			}
		return null;
	}
	
	@Override
	public Optional<Pokemon> findById(Integer id) {
		return pokemonRepo.findById(id);
	}

}
