package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import java.util.*


fun main(){

    var teste= Carro("teste", Motor(1234,12))
    teste.dataDeAquisicao= Date(2023,11,2)
    var teste1= Pessoa("lol",Date(2001,10,3))
    var teste2= Pessoa("lol1",Date(2002,12,2))
    teste1.veiculos.add(teste)
    teste1.venderVeiculo(teste.identificador, teste2)

    println(teste2.veiculos)
}