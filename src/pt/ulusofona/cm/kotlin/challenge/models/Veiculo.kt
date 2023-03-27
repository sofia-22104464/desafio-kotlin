package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate
import java.util.*

open class Veiculo(var identificador: String): Movimentavel {
    var posicao= Posicao(0,0)
    //var dataDeAquisicao: Date= Date(LocalDate.now().year,LocalDate.now().monthValue,LocalDate.now().dayOfMonth)
    var dataDeAquisicao: Date= Date(0,1,0)

    open fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x,y)
    }

}