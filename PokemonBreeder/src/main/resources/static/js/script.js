window.addEventListener('load', function(e){
	console.log('script.js loaded')
	init();
});

function init() {
	document.pokemonForm.lookup.addEventListener('click', function(event){
		event.preventDefault();
		var pokemonId = document.pokemonForm.pokemonId.value;
		if (!isNaN(pokemonId) && pokemonId > 0) {
			getPokemonById(pokemonId);
		}
	})
	
	document.addPokemonForm.addPokemon.addEventListener('click', function(event){
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
      console.log(data[0].id);
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

function postNewPokemon(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/pokemon/', true);
	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let pokemon = JSON.parse(xhr.responseText);
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