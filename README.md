# EventTrackerProject

Currently Deployed @: http://18.118.191.203:8080/PokemonBreeder/

| Return Type      | Route                   | Functionality                         |
|------------------|-------------------------|---------------------------------------|
| `List<Pokemon>`  |`GET api/pokemon`        | Gets all pokemon                      |
| `Pokemon`        |`GET api/pokemon/{id}`   | Gets one pokemon by id                |
| `Pokemon`        |`POST api/pokemon`       | Creates a new pokemon                 |
| `Pokemon`        |`PUT api/pokemon/{id}`   | Replaces an existing pokemon by id    |
| `void`           |`DELETE api/pokemon/{id}`| Deletes an existing pokemon by id     |
| `List<Trainer>`  |`GET api/trainer`        | Gets all trainers                     |
| `Trainer`        |`GET api/trainer/{id}`   | Gets one trainer by id                |
| `Trainer`        |`POST api/trainer`       | Creates a new trainer                 |
| `Trainer`        |`PUT api/trainer/{id}`   | Replaces an existing trainer by id    |
| `void`           |`DELETE api/trainer/{id}`| Deletes an existing trainer by id     |

CRUD Functionality has been implemnted for Pokemon. Users can view, create, update, and delete Pokemon from the database. When updating, the form values will refresh to undefined and the user needs to re search for the pokemon to see the updated changes.
