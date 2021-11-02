package br.com.curtsian.pokedex.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.curtsian.pokedex.R
import br.com.curtsian.pokedex.databinding.PokemonItemBinding
import br.com.curtsian.pokedex.domain.Pokemon
import br.com.curtsian.pokedex.util.gone
import br.com.curtsian.pokedex.util.visible
import com.bumptech.glide.Glide
import java.util.*

class PokemonAdapter(
    private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(
        private val binding: PokemonItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: Pokemon?) = with(binding) {
            item?.let { pokemon ->

                Glide.with(itemView.context).load(pokemon.imageUrl).into(ivPokemon)

                TVnumberPokemon.text = POKEMON_NUMBER.format(item.formattedNumber)

                TVnamePokemon.text = item.formattedName

                TVtype1.text = item.types[ZERO_VALUE].name.replaceFirstChar { name ->
                    if (name.isLowerCase())
                        name.titlecase(Locale.getDefault())
                    else
                        name.toString()
                }

                replaceFirstChar(item)
            }
        }

        private fun replaceFirstChar(item: Pokemon) = with(binding) {
            if (item.types.size > ONE_VALUE) {
                TVtype2.visible()
                TVtype2.text = item.types[ONE_VALUE].name.replaceFirstChar {
                    if (it.isLowerCase())
                        it.titlecase(Locale.getDefault())
                    else
                        it.toString()
                }
            } else {
                TVtype2.gone()
            }
        }
    }

    companion object {
        private const val POKEMON_NUMBER = "N° %s"
        private const val ZERO_VALUE = 0
        private const val ONE_VALUE = 1
    }


}