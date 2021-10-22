import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Pokemon} from 'src/app/models/pokemon'


@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private baseUrl = 'http://localhost:8087/';
  private url = this.baseUrl + 'api/pokemon';

  constructor(
    private http: HttpClient
  ) { }


  index(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('TodoService.index(): Error retrieving Todo list');
      })
    );
  }

}
