package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import java.util.*


fun main(){

    var teste= Carro("teste", Motor(1234,12))
    teste.dataDeAquisicao= Date(2023,11,2)
    println(teste.toString())
}