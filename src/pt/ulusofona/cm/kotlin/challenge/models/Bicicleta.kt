package pt.ulusofona.cm.kotlin.challenge.models

import java.text.SimpleDateFormat

class Bicicleta(identificador: String) : Veiculo(identificador) {
    override fun requerCarta(): Boolean{
        return false
    }

    override fun toString(): String{
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        val current = formatter.format(dataDeAquisicao)
        return "Bicicleta | $identificador | $current | $posicao"
    }
}