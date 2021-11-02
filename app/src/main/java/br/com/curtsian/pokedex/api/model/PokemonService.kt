package br.com.curtsian.pokedex.api.model


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonService  {

    @GET(URLs.POKEMON)
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>


    @GET(URLs.POKEMON_NUMBER)
    fun getPokemon(@Path("number") number: Int): Call<PokemonApiResult>

}