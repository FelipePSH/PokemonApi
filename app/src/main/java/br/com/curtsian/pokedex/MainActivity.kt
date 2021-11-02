package br.com.curtsian.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Choreographer
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.curtsian.pokedex.api.PokemonRepository
import br.com.curtsian.pokedex.domain.Pokemon
import br.com.curtsian.pokedex.domain.PokemonType
import br.com.curtsian.pokedex.view.PokemonAdapter
import br.com.curtsian.pokedex.viewmodel.PokemonViewModel
import br.com.curtsian.pokedex.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvPokemons)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}