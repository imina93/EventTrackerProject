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

import com.skilldistillery.pokemonbreeder.entities.Trainer;
import com.skilldistillery.pokemonbreeder.services.TrainerService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4300" })
public class TrainerController {
	@Autowired
	private TrainerService trainerSvc;
	
	
	@GetMapping("trainer")
	public List<Trainer> trainerIndex() {
		return trainerSvc.getAllTrainers();
	}
	
	

	@PostMapping("trainer")
	public Trainer addTrainer(
			@RequestBody Trainer trainer,
			HttpServletRequest req,
			HttpServletResponse res
			) {
		try {
			trainerSvc.addTrainer(trainer);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(trainer.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
			trainer = null;
		}
		return trainer;
	}
	
	
	@GetMapping("trainer/{id}")
	public Optional<Trainer> showTrainer(
			@PathVariable Integer id,
			HttpServletResponse res) {
		Optional<Trainer> trainer = trainerSvc.findById(id);
		if (trainer == null) {
			res.setStatus(404);
		}
		return trainer;
	}
	
	
	@PutMapping("trainer/{id}")
	public Optional<Trainer> updateTrainer(
			@PathVariable Integer id,
			@RequestBody Optional<Trainer> trainer,
			HttpServletResponse res) {
		try {
			trainer = trainerSvc.updateTrainer(id, trainer);
			if (trainer == null) {
				res.setStatus(400);
			}
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
			trainer = null;
		} return trainer;
	}
	
	
	@DeleteMapping("trainer/{id}")
	public void deleteTrainer(@PathVariable Integer id,
			HttpServletResponse res
			) {
			try {
				trainerSvc.deleteTrainer(id);
				res.setStatus(204);
			} catch (Exception e) {
				System.err.println(e);
				res.setStatus(400);
	}
	
}}
