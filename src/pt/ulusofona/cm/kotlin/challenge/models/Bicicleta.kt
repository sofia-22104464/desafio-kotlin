package pt.ulusofona.cm.kotlin.challenge.models

class Bicicleta(identificador: String) : Veiculo(identificador) {
    override fun requerCarta(): Boolean{
        return false
    }

    override fun toString(): String{
        return "Bicicleta | ${getIdentificador()} | ${getDataDeAquisicao()} | ${getPosicao()}"
    }
}