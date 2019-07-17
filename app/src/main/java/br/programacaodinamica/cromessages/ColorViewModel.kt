package br.programacaodinamica.cromessages

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.programacaodinamica.cromessages.models.NamedColor

class ColorViewModel: ViewModel(){
    var red = 0
        set(value) {
            field = value
            color.value = Color.rgb(value, green, blue)
        }
    var green = 0
        set(value) {
            field = value
            color.value = Color.rgb(red, value, blue)
        }
    var blue = 20
        set(value) {
            field = value
            color.value = Color.rgb(red, green, value)
        }

    val favoriteColors = mutableListOf<NamedColor>()

    val color = MutableLiveData<Int>().apply { value = Color.rgb(red, green, blue) }
    val selectedFragment = MutableLiveData<Int>().apply { value = R.id.text_menu_item }
    val newColor = MutableLiveData<Int>()

    fun syncFavorite(){
        color.value?.let {
            favoriteColors.add(NamedColor(it))
            newColor.value = it
        }
    }
}