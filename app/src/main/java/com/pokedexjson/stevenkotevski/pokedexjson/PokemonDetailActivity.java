package com.pokedexjson.stevenkotevski.pokedexjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.pokedexjson.stevenkotevski.pokedexjson.models.Pokemon;
import com.pokedexjson.stevenkotevski.pokedexjson.networking.GetPokemonDataService;
import com.pokedexjson.stevenkotevski.pokedexjson.networking.PokemonClientReference;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailActivity extends AppCompatActivity {

    private TextView mNameTextView;
    private TextView mHeightTextView;
    private TextView mWeightTextView;

    private TextView mTypeTextView;
    private TextView mHpTextView;
    private TextView mAttackTextView;
    private TextView mDefenseTextView;
    private TextView mSpecialAttackTextView;
    private TextView mSpecialDefenseTextView;
    private TextView mSpeedTextView;


    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        final String pokemonName = getIntent().getStringExtra(PokemonListActivity.POKEMON_EXTRA);

        mNameTextView = (TextView)findViewById(R.id.pokemon_name);
        mHeightTextView = (TextView)findViewById(R.id.pokemon_height);
        mWeightTextView = (TextView)findViewById(R.id.pokemon_weight);

        mTypeTextView = (TextView)findViewById(R.id.pokemon_type);
        mHpTextView = (TextView)findViewById(R.id.pokemon_hp);
        mAttackTextView = (TextView)findViewById(R.id.pokemon_attack);
        mDefenseTextView = (TextView)findViewById(R.id.pokemon_defense);
        mSpecialAttackTextView = (TextView)findViewById(R.id.pokemon_specialattack);
        mSpecialDefenseTextView = (TextView)findViewById(R.id.pokemon_specialdefense);
        mSpeedTextView = (TextView)findViewById(R.id.pokemon_speed);

        mImageView = (ImageView)findViewById(R.id.pokemon_photo);


        GetPokemonDataService service = PokemonClientReference.getRetrofitInstance().create(GetPokemonDataService.class);
        Call<Pokemon> call = service.getPokemon(pokemonName);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon = response.body();

                Picasso.Builder builder = new Picasso.Builder(PokemonDetailActivity.this);
                builder.downloader(new OkHttp3Downloader( PokemonDetailActivity.this));
                builder.build().load(pokemon.sprites.frontDefault).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(mImageView);


                mNameTextView.setText("Name: " + pokemon.name);
                mHeightTextView.setText("Height: " + pokemon.height);
                mWeightTextView.setText("Weight: " + pokemon.weight);
                mTypeTextView.setText("Type: " + pokemon.type);
                mHpTextView.setText("HP: " + pokemon.hp);
                mAttackTextView.setText("Attack: " + pokemon.attack);
                mDefenseTextView.setText("Defense: " + pokemon.defense);
                mSpecialAttackTextView.setText("Special Attack: " + pokemon.specialattack);
                mSpecialDefenseTextView.setText("Special Defense: " + pokemon.specialdefense);;
                mSpeedTextView.setText("Speed: " + pokemon.speed);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(PokemonDetailActivity.this, "Error getting this data", Toast.LENGTH_SHORT);
            }
        });



    }

}
