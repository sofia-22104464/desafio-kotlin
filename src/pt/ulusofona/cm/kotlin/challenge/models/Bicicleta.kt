package pt.ulusofona.cm.kotlin.challenge.models

class Bicicleta(identificador: String) : Veiculo(identificador) {
    override fun requerCarta(): Boolean{
        return false
    }

    override fun toString(): String{
        var dia= String.format("%02d",dataDeAquisicao.date)
        var mes= String.format("%02d",dataDeAquisicao.month)
        return "Bicicleta | $identificador | $dia-$mes-${dataDeAquisicao.year} | $posicao"
    }
}