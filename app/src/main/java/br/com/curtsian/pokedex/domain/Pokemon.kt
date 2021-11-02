package br.com.curtsian.pokedex.domain

import br.com.curtsian.pokedex.api.model.URLs.Companion.URL_IMAGE
import java.util.*

data class Pokemon(
    val number: Int,
    val name: String,
    val types: List<PokemonType>
) {

    val formattedNumber = number.toString().padStart(3, '0')
    val formattedName =
        name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    val imageUrl = URL_IMAGE.format(formattedNumber)


}

