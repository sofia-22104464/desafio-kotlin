package pt.ulusofona.cm.kotlin.challenge.models

class Carro(identificador: String, private var motor: Motor) : Veiculo(identificador) {

    fun getMotor(): Motor{
        return motor
    }

    override fun requerCarta(): Boolean{
        return true
    }

    override fun toString(): String{
        return "Carro | ${getIdentificador()} | ${getDataDeAquisicao()} | ${getPosicao()}"
    }
}