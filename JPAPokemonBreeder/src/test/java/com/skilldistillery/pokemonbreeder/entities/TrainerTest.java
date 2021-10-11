package com.skilldistillery.pokemonbreeder.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainerTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Trainer trainer;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAPokemonBreeder");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();

		trainer = em.find(Trainer.class, 1);
	}


	@AfterEach
	void tearDown() throws Exception {
		em.close();
		trainer = null;
		
	}

	@Test
	void test_entity_mapping() {
		assertNotNull(trainer);
		assertEquals("admin", trainer.getName());
	}
	
	@Test 
	void test_trainer_pokemon_relationship_mapping() {
		assertNotNull(trainer);
		assertTrue(trainer.getRegisteredPokemon().size() > 0);
		
	}

}
