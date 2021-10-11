package com.skilldistillery.pokemonbreeder.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokemonTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Pokemon pokemon;

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

		pokemon = em.find(Pokemon.class, 1);
	}


	@AfterEach
	void tearDown() throws Exception {
		em.close();
		pokemon = null;
		
	}

	@Test
	void test_entity_mapping() {
		assertNotNull(pokemon);
		assertEquals("Charmander", pokemon.getName());
	}
	
	@Test
	void test_pokemon_trainer_relationship_mapping() {
		assertNotNull(pokemon);
		assertEquals("admin", pokemon.getTrainer().getName());
		
	}

}
