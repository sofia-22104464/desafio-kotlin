package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit
import java.util.*


class Pessoa(var nome: String, var dataDeNascimento: Date): Movimentavel {
    var veiculos = ArrayList<Veiculo>()
    var carta: Carta? = null
    var posicao= Posicao(0,0)


    fun comprarVeiculo(veiculo: Veiculo){
        veiculo.dataDeAquisicao= Calendar.getInstance().time
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo{
        var count= 0
        while(count < veiculos.size){
            if(veiculos[count].identificador == identificador){
                return veiculos[count]
            }
            count++
        }
        throw VeiculoNaoEncontradoException("O veiculo nao foi encontrado!")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa){
        val veiculo= pesquisarVeiculo(identificador)
        comprador.comprarVeiculo(veiculo)
        veiculos.remove(veiculo)
    }

    fun moverVeiculoPara(identificador: String, x:Int, y:Int){
        val veiculo= pesquisarVeiculo(identificador)
        veiculos.remove(veiculo)
        if(veiculo.requerCarta()){
            if(!temCarta()){
                veiculos.add(veiculo)
                throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
            }else{
                var carro= veiculo as Carro
                carro.motor.ligar()
                carro.moverPara(x,y)
                moverPara(x,y)
                carro.motor.desligar()
                veiculos.add(carro)
            }
        }else{
            veiculo.moverPara(x,y)
            moverPara(x,y)
            veiculos.add(veiculo)
        }
    }

    fun temCarta(): Boolean{
        return this.carta != null
    }

    fun tirarCarta(){
        if(Period.between(LocalDate.of(dataDeNascimento.year,dataDeNascimento.month + 1,dataDeNascimento.date), LocalDate.now()).years < 18){
            throw MenorDeIdadeException("Não pode tirar a carta visto que é menor!")
        }else{
            this.carta= Carta()
        }
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x,y)
    }

    override fun toString(): String{
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        val current = formatter.format(dataDeNascimento)
        return "Pessoa | $nome | $current | $posicao"
    }
}
