package br.programacaodinamica.cromessages.models

import br.programacaodinamica.cromessages.toHexCode

class NamedColor(val colorRepr: Int){

    val name: String
        get() = colorRepr.toHexCode()
}