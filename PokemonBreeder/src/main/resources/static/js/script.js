window.addEventListener('load', function(e) {
	console.log('script.js loaded')
	init();
});

function init() {
	document.pokemonForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var pokemonId = document.pokemonForm.pokemonId.value;
		if (!isNaN(pokemonId) && pokemonId > 0) {
			getPokemonById(pokemonId);
		}
	})

	document.addPokemonForm.addPokemon.addEventListener('click', function(event) {
		event.preventDefault();
		postNewPokemon();
	});
}

function getPokemon() {

	console.log("got to getPokemon");

	var xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/pokemon/');

	xhr.onreadystatechange = function() {
		if (xhr.status < 400 && xhr.readyState === 4) {
			// convert responseText to JSON
			let pokemon = JSON.parse(xhr.responseText);
			// print out JSON data
			displayPokemon(pokemon);


		} else if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error('Pokemon not found');
		}
	};

	xhr.send(null);

}

function getPokemonById(pokemonId) {
	console.log('getPokemonById(): pokemonId is ' + pokemonId);
	let xhr = new XMLHttpRequest();
	console.log('xhr.readyState = ' + xhr.readyState);
	xhr.open('GET', 'api/pokemon/' + pokemonId);
	console.log('xhr.readyState = ' + xhr.readyState);
	xhr.onreadystatechange = function() {
		console.log('xhr.readyState = ' + xhr.readyState);
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let pokemonJson = xhr.responseText;
				console.log(pokemonJson);
				let pokemon = JSON.parse(pokemonJson);
				console.log(pokemon);
				displayPokemon(pokemon);
			} else {

			}
		}
	}
	console.log('Before Send: xhr.readyState = ' + xhr.readyState);
	xhr.send();
	console.log('After Send : xhr.readyState = ' + xhr.readyState);
}

function postNewPokemon() {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/pokemon/', true);
	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				getPokemon();
				console.log("Pokemon added");
				alert("Pokemon Added");
			} else {
				document.getElementById('pokemonData').textContent = 'Pokemon Not Found';
				console.log(xhr.responseText);
			}
		}
	};

	var pokemon = {
		name: document.addPokemonForm.name.value,
		nature: document.addPokemonForm.nature.value,
		ability: document.addPokemonForm.ability.value,
		ivSpread: document.addPokemonForm.ivSpread.value,
		notes: document.addPokemonForm.notes.value,
		// Hardcoded admin as default trainer.
		trainer: {
			id: 1
		}
	};
	console.log(pokemon);
	console.log("test object added   " + document.addPokemonForm.name.value);
	var pokemonJson = JSON.stringify(pokemon); // Convert JS object to JSON string
	xhr.send(pokemonJson);
	document.addPokemonForm.reset();
	displayPokemon(pokemon);
}


function displayPokemon(pokemon) {
	var pokemonDiv = document.getElementById('pokemonData');
	pokemonDiv.style.backgroundColor = 'rgb(220,220,220)';
	pokemonDiv.textContent = '';
	let h1 = document.createElement('h1');
	h1.textContent = pokemon.name;
	pokemonDiv.appendChild(h1);
	let bq = document.createElement('blockquote')
	bq.textContent = pokemon.notes;
	pokemonDiv.appendChild(bq);
	let ul = document.createElement('ul');
	pokemonDiv.appendChild(ul);
	let liNature = document.createElement('li');
	liNature.textContent = "Nature: " + pokemon.nature;
	ul.appendChild(liNature);
	let liAbility = document.createElement('li');
	liAbility.textContent = "Ability: " + pokemon.ability;
	ul.appendChild(liAbility);
	let liIvs = document.createElement('li');
	liIvs.textContent = "IV Spread: " + pokemon.ivSpread;
	ul.appendChild(liIvs);
	let deleteButton = document.createElement('button');
	deleteButton.textContent = 'Delete';
	deleteButton.addEventListener('click', function(e) {
		deletePokemon(pokemon.id);

	});
	pokemonDiv.appendChild(deleteButton);
	let updateButton = document.createElement('button');
	updateButton.textContent = 'Edit Information';
	updateButton.addEventListener('click', function(e) {
		updatePokemon(pokemon.id);

	});
	pokemonDiv.appendChild(updateButton);
	document.addPokemonForm.name.value = pokemon.name;
	document.addPokemonForm.nature.value = pokemon.nature;
	document.addPokemonForm.ability.value = pokemon.ability;
	document.addPokemonForm.notes.value = pokemon.notes;
	document.addPokemonForm.ivSpread.value = pokemon.ivSpread;

}

function updatePokemon(pokemonId) {
	// e.preventDefault();
	var xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/pokemon/' + pokemonId, true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) { // Ok or Created
				getPokemon();
				console.log("Pokemon updated");
				alert("Pokemon updated");
			} else {

				document.getElementById('pokemonData').textContent = 'Pokemon Could Not Be Updated';
				console.log(xhr.responseText);
			}
		}
	};
	var pokemon = {
		id: document.pokemonForm.id.value,
		name: document.addPokemonForm.name.value,
		nature: document.addPokemonForm.nature.value,
		ability: document.addPokemonForm.ability.value,
		ivSpread: document.addPokemonForm.ivSpread.value,
		notes: document.addPokemonForm.notes.value,
		// Hardcoded admin as default trainer.
		trainer: {
			id: 1
		}
	};
	console.log("Updated object   " + document.addPokemonForm.name.value);
	var pokemonJson = JSON.stringify(pokemon); // Convert JS object to JSON string
	xhr.send(pokemonJson);
	document.pokemonForm.reset();
	displayPokemon(pokemon);
}

function deletePokemon(pokemonId) {
	// e.preventDefault();
	var xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'api/pokemon/' + pokemonId, true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {

		if (xhr.readyState === 4 && xhr.status === 204) { // Ok or Created

			getPokemon();
			console.log("Pokemon deleted");
			alert("Pokemon deleted");
		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error('ERROR: ' + xhr.status + ': ' + xhr.responseText);
		}

	};

	xhr.send();

	document.pokemonForm.reset();

}
