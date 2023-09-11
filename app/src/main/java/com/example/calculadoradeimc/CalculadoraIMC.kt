package com.example.calculadoradeimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale


class CalculadoraIMC : AppCompatActivity() {
    //aqui se encontra a classe ou seja activity q estou

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_imc)

        val editPeso = findViewById<EditText>(R.id.editPeso)
        val editAltura = findViewById<EditText>(R.id.editAltura)
        val total = findViewById<TextView>(R.id.textResultado)
        val calcular = findViewById<Button>(R.id.buttonCalcular)
        val voltar = findViewById<Button>(R.id.button_back_IMC)
        // aqui estou criando as variaveis q vou utilizar dentro do projeto
        // obs sendo q estou ja resgatando algumas strings usando o R.id e pseudonome

        calcular.setOnClickListener {
            // aqui estou criando a função do botao de calcular

            val formatPeso: NumberFormat = NumberFormat.getInstance(Locale.FRANCE)
            val numberPeso: Number = formatPeso.parse(editPeso.text.toString())
            val dPeso = numberPeso.toDouble()
            //nesta parte estou mudando o formato do numero dizendo q o NumberFormat recebe a instancia de localidade da frança mudando o idioma do editText referente a peso
            // e tbm fazendo ele se converter de "string" para "toDouble" para quando aparecer o calculo o codigo entenda q sao numeros

            val formatAltura: NumberFormat = NumberFormat.getInstance(Locale.FRANCE)
            val numberAltura: Number = formatAltura.parse(editAltura.text.toString())
            val dAltura = numberAltura.toDouble()
            //nesta parte estou mudando o formato do numero dizendo q o NumberFormat recebe a instancia de localidade da frança mudando o idioma do editText referente a Altura
            // e tbm fazendo ele se converter de "string" para "toDouble" para quando aparecer o calculo o codigo entenda q sao numeros

            //val peso = editPeso.text.toString().toDouble();
            //val altura = editAltura.text.toString().toDouble();
            //val result = peso / (altura * altura)

            // essa parte deixei em citação pq eu usava essa formula para calcular mas ele so ficava em ingles ou seja usando ponto no padrao americano ao inves de virgula

            val result = dPeso / (dAltura * dAltura)
            val resultString = String.format("%.3f", result)
            // aqui ja estou informando q a variavel result recebe a formula da variavel peso sendo dividido pela variavel altura q antes de dividido se multiplicou pela altura
            // logo apos receber o resultado informo ao codigo q o resultado da stringresult q esta em text vai receber o formato descrito, assim ele pode conter numeros e alguns caracteres

            if (result <= 0 ) {
                total.text = getString(R.string.imc_falso)
            } else if (result < 19) {
                total.text = getString(R.string.imc_magro, resultString)
            } else if (result <= 19 || result < 25) {
                total.text = getString(R.string.imc_no_peso, resultString)
            } else if (result <= 25 || result < 30) {
                total.text = getString(R.string.imc_a_cima_do_peso, resultString)
            } else if (result <= 30 || result < 40) {
                total.text = getString(R.string.imc_gordo1, resultString)
            } else if ( result >= 40){
                total.text = getString(R.string.imc_gordo2, resultString)
            }
            // aqui sao as opçoes de resultado onde o texto é recuperado da classe ou tipo de arquivo strings obs: "ainda n sei explicar isso"
        }
        voltar.setOnClickListener {
            Intent(this, MainActivity::class.java)
            finish()
            // aqui ja estou criando a função do botao de voltar
            // onde digo q ha uma intenção de ir dessa pagina para a MainActivity ou seja a primeira pagina, colocando o finish() significa q é uma ação finalizada de volta e n continuidade
            // assim quando usar o voltar do celular ele n vai ficar voltando pra pagina anterior pois o fish ja finalizou aquela açao
        }
    }
}