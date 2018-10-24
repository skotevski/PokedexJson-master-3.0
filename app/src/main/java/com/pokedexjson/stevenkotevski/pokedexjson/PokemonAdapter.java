package com.pokedexjson.stevenkotevski.pokedexjson;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pokedexjson.stevenkotevski.pokedexjson.models.Pokemon;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {

    private List<String> mPokemonList;

    // sample constructor?
    public PokemonAdapter() {
        mPokemonList = Arrays.asList("");
    }

    public PokemonAdapter(List<String> pokemonList) {

        mPokemonList = pokemonList;
    }

    @Override
    public PokemonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View pokemonView = inflater.inflate(R.layout.list_item_pokemon, parent, false);

        PokemonHolder pokemonHolder = new PokemonHolder(pokemonView);

        return pokemonHolder;
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.PokemonHolder pokemonHolder, int position) {
        String pokemon = mPokemonList.get(position);

        TextView nameTextView = pokemonHolder.pokemonNameTextView;
        nameTextView.setText(pokemon);

        TextView heightTextView = pokemonHolder.pokemonHeightTextView;
        heightTextView.setText(pokemon);

        TextView weightTextView = pokemonHolder.pokemonWeightTextView;
        weightTextView.setText(pokemon);

    }

    @Override
    public int getItemCount() {
        return mPokemonList.size();
    }

    public class PokemonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView pokemonNameTextView;
        public TextView pokemonHeightTextView;
        public TextView pokemonWeightTextView;
        public ImageView pokemonImageView;

        public PokemonHolder(View itemView) {
            super(itemView);
            pokemonNameTextView = (TextView)itemView.findViewById(R.id.pokemon_name);
            pokemonHeightTextView = (TextView)itemView.findViewById(R.id.pokemon_height);
            pokemonWeightTextView = (TextView)itemView.findViewById(R.id.pokemon_weight);
            pokemonImageView = (ImageView)itemView.findViewById(R.id.pokemon_photo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String pokemon = mPokemonList.get(getLayoutPosition());
            Intent intent = new Intent(itemView.getContext(), PokemonDetailActivity.class);
            intent.putExtra(PokemonListActivity.POKEMON_EXTRA, pokemon);
            itemView.getContext().startActivity(intent);
        }

    }
}
