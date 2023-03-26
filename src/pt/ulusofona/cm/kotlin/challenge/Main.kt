package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor

fun main(){
    var teste= Carro("teste", Motor(200,100))
    println(teste.toString())
}