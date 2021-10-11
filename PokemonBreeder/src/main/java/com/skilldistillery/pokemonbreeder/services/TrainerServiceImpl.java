package com.skilldistillery.pokemonbreeder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.pokemonbreeder.entities.Trainer;
import com.skilldistillery.pokemonbreeder.repositories.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {

	
	@Autowired
	private TrainerRepository trainerRepo;
	
	@Override
	public List<Trainer> getAllTrainers() {
		return trainerRepo.findAll();
	}

	@Override
	public Trainer addTrainer(Trainer trainer) {
		return trainerRepo.saveAndFlush(trainer);
	}

	@Override
	public void deleteTrainer(int id) {
		trainerRepo.deleteById(id);
	}

	@Override
	public Optional<Trainer> updateTrainer(int trainerId, Optional<Trainer> trainer) {
		Optional<Trainer> registeredTrainer = trainerRepo.findById(trainerId);
		if (registeredTrainer != null) {
			registeredTrainer = trainer;
		}
		return registeredTrainer;
	}

	@Override
	public Optional<Trainer> findById(Integer id) {
		return trainerRepo.findById(id);
	}

}
