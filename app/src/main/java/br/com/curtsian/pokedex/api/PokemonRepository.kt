package br.com.curtsian.pokedex.api


import br.com.curtsian.pokedex.api.model.PokemonApiResult
import br.com.curtsian.pokedex.api.model.PokemonService
import br.com.curtsian.pokedex.api.model.PokemonsApiResult
import br.com.curtsian.pokedex.api.model.URLs
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository  {
    private const val LIMIT_POKEMONS = 151
    private val service: PokemonService

    init {

        //singleton
        val retrofit = Retrofit.Builder(
        ).baseUrl(URLs.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        service = retrofit.create(PokemonService::class.java)

    }


    fun listPokemons(limit: Int = LIMIT_POKEMONS): PokemonsApiResult? {
        val call = service.listPokemons(limit)


        return call.execute().body()
    }



    fun getPokemon(number: Int): PokemonApiResult? {
        val call = service.getPokemon(number)

        return call.execute().body() }





}
