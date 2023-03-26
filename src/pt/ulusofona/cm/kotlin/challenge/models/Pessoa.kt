package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.*


class Pessoa(var nome: String, var dataDeNascimento: Date) {
    var veiculos = ArrayList<Veiculo>()
    var carta: Carta? = null
    var posicao= Posicao(0,0)

    fun comprarVeiculo(veiculo: Veiculo){
        val localDate = LocalDate.now()
        val localDateTime = localDate.atStartOfDay()
        val data = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())
        veiculo.dataDeAquisicao= data
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
                carro.posicao.alterarPosicaoPara(x,y)
                posicao.alterarPosicaoPara(x,y)
                carro.motor.desligar()
                veiculos.add(carro)
            }
        }else{
            veiculo.posicao.alterarPosicaoPara(x,y)
            posicao.alterarPosicaoPara(x,y)
            veiculos.add(veiculo)
        }
    }

    fun temCarta(): Boolean{
        return this.carta != null
    }

    fun tirarCarta(){
        if(Period.between(LocalDate.of(dataDeNascimento.year,dataDeNascimento.month,dataDeNascimento.day), LocalDate.now()).years < 18){
            throw MenorDeIdadeException("Não pode tirar a carta visto que é menor!")
        }else{
            this.carta= Carta()
        }
    }

    override fun toString(): String{
        return "Pessoa | $nome | ${dataDeNascimento.day}-${dataDeNascimento.month}-${dataDeNascimento.year} | $posicao"
    }
}