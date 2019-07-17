package br.programacaodinamica.cromessages

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorViewModel: ViewModel(){
    var red = 0
        set(value) {
            color.value = Color.rgb(value, green, blue)
        }
    var green = 0
        set(value) {
            color.value = Color.rgb(red, value, blue)
        }
    var blue = 0
        set(value) {
            color.value = Color.rgb(red, green, value)
        }
    var color = MutableLiveData<Int>()
}