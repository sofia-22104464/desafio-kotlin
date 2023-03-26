package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(private var cavalos: Int, private var cilindrada: Int): Ligavel {
    private var ligado: Boolean = false

    override fun ligar() {
        if(ligado){
            throw VeiculoLigadoException("O veiculo já se encontra ligado!")
        }else{
            ligado= true
        }
    }

    override fun desligar() {
        if(!ligado){
            throw VeiculoDesligadoException("O veiculo já se encontra desligado!")
        }else{
            ligado= false
        }
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun toString(): String{
        return "Motor | $cavalos | $cilindrada"
    }
}