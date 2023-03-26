package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.util.*

open class Veiculo(private var identificador: String) {
    private lateinit var posicao: Posicao
    private lateinit var dataDeAquisicao: Date

    open fun requerCarta(): Boolean {
        return true
    }

    fun getDataDeAquisicao(): Date{
        return this.dataDeAquisicao
    }

    fun setDataDeAquisicao(data: Date){
        this.dataDeAquisicao=data
    }

    fun getPosicao(): Posicao{
        return posicao
    }

    fun getIdentificador(): String{
        return this.identificador
    }

}