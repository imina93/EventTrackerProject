package com.skilldistillery.pokemonbreeder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.pokemonbreeder.entities.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

}
