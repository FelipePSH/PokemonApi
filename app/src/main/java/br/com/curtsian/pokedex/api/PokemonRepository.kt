package br.com.curtsian.pokedex.api

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import br.com.curtsian.pokedex.api.model.PokemonApiResult
import br.com.curtsian.pokedex.api.model.PokemonService
import br.com.curtsian.pokedex.api.model.PokemonsApiResult
import br.com.curtsian.pokedex.domain.Pokemon
import br.com.curtsian.pokedex.view.PokemonAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository  {
    private val service: PokemonService
    //https://pokeapi.co/api/v2/pokemon/?limit=151

    init {

        //singleton
        val retrofit = Retrofit.Builder(
        ).baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        service = retrofit.create(PokemonService::class.java)

    }


    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
        val call = service.listPokemons(limit)


        return call.execute().body()
/*
        call.enqueue(object : Callback<PokemonsApiResult>{
            override fun onResponse(
                call: Call<PokemonsApiResult>,
                response: Response<PokemonsApiResult>
            ) {
                if (response.isSuccessful){
                    val body = response.body()

                    body?.results?.let {
                        Log.d("POKEMON_API", it[5].name)
                    }
                }
                Log.d("Pokemon_API", "Lista de pokemons carregada.")
            }

            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
                Log.e("Pokemon_API", "Erro ao carregar.", t)
            }
        }) */
    }



    fun getPokemon(number: Int): PokemonApiResult? {
        val call = service.getPokemon(number)

        return call.execute().body() }


}