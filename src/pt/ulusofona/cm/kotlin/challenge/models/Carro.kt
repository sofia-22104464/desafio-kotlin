package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.text.SimpleDateFormat

class Carro(identificador: String, var motor: Motor) : Veiculo(identificador), Ligavel {

    override fun requerCarta(): Boolean{
        return true
    }

    override fun ligar() {motor.ligar()}

    override fun desligar() {motor.desligar()}

    override fun estaLigado(): Boolean {return motor.estaLigado()}

    override fun toString(): String{
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        val current = formatter.format(dataDeAquisicao)
        return "Carro | $identificador | $current | $posicao"
    }
}