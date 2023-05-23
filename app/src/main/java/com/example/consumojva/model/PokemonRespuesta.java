package com.example.consumojva.model;

import java.util.ArrayList;

public class PokemonRespuesta {
    private ArrayList<Pokemon>results;

    public PokemonRespuesta() {
    }

    public PokemonRespuesta(ArrayList<Pokemon> results) {
        this.results = results;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PokemonRespuesta{" +
                "results=" + results +
                '}';
    }
}
