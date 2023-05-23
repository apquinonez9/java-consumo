package com.example.consumojva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.consumojva.model.Pokemon;
import com.example.consumojva.model.PokemonRespuesta;
import com.example.consumojva.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
Retrofit retrofit;
ListView ListPokemones;

ArrayAdapter<Pokemon>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListPokemones=findViewById(R.id.ListPokemones);

        retrofit=new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatos();
    }

    private void obtenerDatos() {
        PokeapiService service=retrofit.create(PokeapiService.class);
        Call<PokemonRespuesta>pokemonRespuestaCall=service.obtenerlistaPokemon();
        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if (response.isSuccessful()) {
                    PokemonRespuesta pokemonRespuesta=response.body();

                    ArrayList<Pokemon>pokemon=pokemonRespuesta.getResults();
                    adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,pokemon);
                    ListPokemones.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "sss"+response.body(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();


            }
        });

    }
}