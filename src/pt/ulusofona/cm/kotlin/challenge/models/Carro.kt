package pt.ulusofona.cm.kotlin.challenge.models

class Carro(identificador: String, var motor: Motor) : Veiculo(identificador) {

    override fun requerCarta(): Boolean{
        return true
    }

    override fun toString(): String{
        return "Carro | $identificador | $dataDeAquisicao | $posicao"
    }
}