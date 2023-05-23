package com.example.consumojva.pokeapi;

import com.example.consumojva.model.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService {

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerlistaPokemon();
}
