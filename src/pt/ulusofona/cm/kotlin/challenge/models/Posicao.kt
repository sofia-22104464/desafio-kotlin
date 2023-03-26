package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

class Posicao( var x: Int = 0, var y: Int = 0) {

    fun alterarPosicaoPara(x:Int, y:Int){
        if(this.x == x && this.y == y){
            throw AlterarPosicaoException("Já está nesta posição!")
        }else{
            this.x=x
            this.y=y
        }
    }

    override fun toString(): String{
        return "Posicao | x:$x | y:$y"
    }
}