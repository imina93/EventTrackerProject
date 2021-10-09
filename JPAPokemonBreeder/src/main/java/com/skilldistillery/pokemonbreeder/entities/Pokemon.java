package com.skilldistillery.pokemonbreeder.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String nature;
	private String ability;
	@Column(name="iv_spread")
	private String ivSpread;
	private String notes;

	

	public Pokemon(int id, String name, String nature, String ability, String ivSpread, String notes) {
		super();
		this.id = id;
		this.name = name;
		this.nature = nature;
		this.ability = ability;
		this.ivSpread = ivSpread;
		this.notes = notes;
	}

	public Pokemon() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}
	

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getIvSpread() {
		return ivSpread;
	}

	public void setIvSpread(String ivSpread) {
		this.ivSpread = ivSpread;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pokemon [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", nature=");
		builder.append(nature);
		builder.append(", ability=");
		builder.append(ability);
		builder.append(", ivSpread=");
		builder.append(ivSpread);
		builder.append(", notes=");
		builder.append(notes);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return id == other.id;
	}

}
