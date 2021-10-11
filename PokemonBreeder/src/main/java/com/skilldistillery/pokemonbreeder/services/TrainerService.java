package com.skilldistillery.pokemonbreeder.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.pokemonbreeder.entities.Trainer;

public interface TrainerService {

	List<Trainer> getAllTrainers();

	Trainer addTrainer(Trainer trainer);

	void deleteTrainer(int id);

	Optional<Trainer> updateTrainer(int trainerId, Optional<Trainer> trainer);

	Optional<Trainer> findById(Integer id);

}
