window.addEventListener('load', function(e){
	console.log('script.js loaded')
	init();
});

function init() {
	document.pokemonForm.lookup.addEventListener('click', function(event){
		event.preventDefault();
		var pokemonId = document.pokemonForm.pokemonId.value;
		if (!isNaN(pokemonId) && pokemonId > 0) {
			getPokemon(pokemonId);
		}
	})
	
	
	document.addPokemonForm.addPokemon.addEventListener('click', function(event){
		event.preventDefault();
		let pokeForm = document.addPokemonForm;
		let newPokemon = {
			name: pokeForm.name.value,
			nature: pokeForm.nature.value,
			ability: pokeForm.ability.value,
			ivSpread: pokeForm.ivSpread.value,
			notes: pokeForm.notes.value
		};
		console.log(newPokemon);
		postNewPokemon(newPokemon);
		
	});
}

function getPokemon(pokemonId) {
	console.log('getPokemon(): pokemonId is ' + pokemonId);
	let xhr = new XMLHttpRequest();
	console.log('xhr.readyState = ' + xhr.readyState);
	xhr.open('GET', 'api/pokemon/' + pokemonId);
	console.log('xhr.readyState = ' + xhr.readyState);
	xhr.onreadystatechange = function(){
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

function postNewPokemon(newPokemon){
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/pokemon');
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let pokemon = JSON.parse(xhr.responseText);
				displayPokemon(pokemon);
			}
		}
		else {
			// TODO
		};
	}
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newPokemon));
}

function displayPokemon(pokemon){
	var pokemonDiv = document.getElementById('pokemonData');
	pokemonDiv.textContent = '';
	let h1 = document.createElement('h1');
	h1.textContent = pokemon.name;
	pokemonDiv.appendChild(h1);
	let bq = document.createElement('blockquote')
	bq.textContent = pokemon.notes;
	pokemonDiv.appendChild(bq);	
	let ul = document.createElement('ul');
	pokemonDiv.appendChild(ul);
	let li = document.createElement('li');
	li.textContent = "Nature: " + pokemon.nature;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = "Ability: " + pokemon.ability;
	ul.appendChild(li);
	li = document.createElement('li');
	li.textContent = "IV Spread: " + pokemon.ivSpread;
	ul.appendChild(li);
}

