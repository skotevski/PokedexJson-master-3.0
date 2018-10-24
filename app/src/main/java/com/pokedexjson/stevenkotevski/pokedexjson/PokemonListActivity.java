package com.pokedexjson.stevenkotevski.pokedexjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PokemonListActivity extends AppCompatActivity {



    public static final String POKEMON_EXTRA = "com.pokedexjson.stevenkotevski.pokedexjson";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        List<String> pokemonList = new ArrayList<>();

        pokemonList.add("pikachu");
        pokemonList.add("salamance");
        pokemonList.add("mewtwo");

        // Maybe using the wrong variables here...

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.pokemon_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        PokemonAdapter adapter = new PokemonAdapter(pokemonList);
        recyclerView.setAdapter(adapter);

        //requestJsonbject();


    }




}
