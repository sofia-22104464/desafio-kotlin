package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.util.*

open class Veiculo(var identificador: String) {
    lateinit var posicao: Posicao
    lateinit var dataDeAquisicao: Date

    open fun requerCarta(): Boolean {
        return true
    }

}