package com.pokedexjson.stevenkotevski.pokedexjson.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import com.pokedexjson.stevenkotevski.pokedexjson.models.Pokemon;

public interface GetPokemonDataService {
    @GET("api/v2/pokemon/{name}")
    Call<Pokemon> getPokemon(@Path("name") String name);
}
