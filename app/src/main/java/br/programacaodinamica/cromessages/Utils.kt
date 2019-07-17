package br.programacaodinamica.cromessages

import android.widget.EditText
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager


const val validHexChars = "0123456789ABCDEF"

fun isValidHexCode(value: String): Boolean {
    if (value.length == 6 || value.length == 8){
        for (c in value){
            if ((c in validHexChars).not()){
                return false
            }
        }
        return true
    }
    return false
}


fun EditText.on(actionId: Int, action:()->Unit){
    this.setOnEditorActionListener { v, receivedActionId, _ ->
        if (actionId == receivedActionId){
            // performs action
            action()
            // closes the soft keyboard
            val imm = v.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.windowToken, 0)
            true
        } else {
            false
        }
    }
}