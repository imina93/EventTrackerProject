package com.skilldistillery.pokemonbreeder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.pokemonbreeder.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

}
