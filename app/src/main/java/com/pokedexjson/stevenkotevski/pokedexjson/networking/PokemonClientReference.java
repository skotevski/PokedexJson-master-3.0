package com.pokedexjson.stevenkotevski.pokedexjson.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PokemonClientReference {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://pokeapi.co/";

    public static Retrofit getRetrofitInstance() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
