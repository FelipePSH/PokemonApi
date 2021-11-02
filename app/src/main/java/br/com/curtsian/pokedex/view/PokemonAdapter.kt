package br.com.curtsian.pokedex.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.curtsian.pokedex.R
import br.com.curtsian.pokedex.domain.Pokemon
import com.bumptech.glide.Glide
import java.util.*

class PokemonAdapter(
    private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindView(item: Pokemon?) = with(itemView) {
            val ivPokemon = findViewById<ImageView>(R.id.IVpokemon)
            val tvnumberPokemon = findViewById<TextView>(R.id.TVnumberPokemon)
            val tvnamePokemon = findViewById<TextView>(R.id.TVnamePokemon)
            val tvType1 = findViewById<TextView>(R.id.TVtype1)
            val tvType2 = findViewById<TextView>(R.id.TVtype2)

            item?.let{

                Glide.with(itemView.context).load(it.imageUrl).into(ivPokemon)


                tvnumberPokemon.text = "N° ${item.formattedNumber}"
                tvnamePokemon.text = item.formattedName
                tvType1.text = item.types[0].name.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }

                if (item.types.size > 1) {
                    tvType2.visibility = View.VISIBLE
                    tvType2.text = item.types[1].name.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.getDefault()
                        ) else it.toString()
                    }

                } else {
                    tvType2.visibility = View.GONE
                }
            }


        }


    }


}