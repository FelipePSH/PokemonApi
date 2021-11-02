package br.com.curtsian.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.curtsian.pokedex.domain.Pokemon

class PokemonViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         return PokemonViewModel() as T
    }


}