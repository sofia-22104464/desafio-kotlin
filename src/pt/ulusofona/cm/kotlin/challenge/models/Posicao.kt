package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

class Posicao(private var x: Int = 0, private var y: Int = 0): Movimentavel {

    fun alterarPosicaoPara(x:Int, y:Int){
        if(this.x == x && this.y == y){
            throw AlterarPosicaoException("Já está nesta posição!")
        }else{
            this.x=x
            this.y=y
        }
    }

    override fun moverPara(x: Int, y: Int) {
        alterarPosicaoPara(x,y)
    }

    fun getX(): Int{
        return this.x
    }

    fun getY(): Int{
        return this.y
    }

    override fun toString(): String{
        return "Posicao | x:$x | y:$y"
    }
}