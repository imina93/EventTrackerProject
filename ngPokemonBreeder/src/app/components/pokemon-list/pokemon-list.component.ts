import { Component, OnInit } from '@angular/core';
import { PokemonService } from 'src/app/services/pokemon.service';
import {Pokemon} from 'src/app/models/pokemon'

@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html',
  styleUrls: ['./pokemon-list.component.css']
})
export class PokemonListComponent implements OnInit {

  pokemons: Pokemon[]=[];

  constructor(
    private pokeService: PokemonService
  ) { }

  ngOnInit(): void {
    this.loadPokemon();
  }

  loadPokemon() {
    this.pokeService.index().subscribe(
      pokemons=>{this.pokemons = pokemons;

      },
      fail=>{
        console.error('PokemonListComponent.loadPokemon(): error loading pokemon');
        console.error(fail);
      }
    )
  }
}
