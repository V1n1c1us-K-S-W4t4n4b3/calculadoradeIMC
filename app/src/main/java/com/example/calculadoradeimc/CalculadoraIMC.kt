package com.example.calculadoradeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.calculadoradeimc.databinding.ActivityCalculadoraImcBinding

class calculadoraIMC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_imc)

        val peso = findViewById(R.id.editPeso) as EditText
        val altura = findViewById(R.id.editAltura) as EditText
        val total = findViewById(R.id.textResultado) as TextView
        val calcular = findViewById(R.id.buttonCalcular) as Button
        val voltar = findViewById(R.id.button_back_IMC) as Button
        val result: Double

        calcular.setOnClickListener {
            val peso = peso.text.toString().toDouble();
            val altura = altura.text.toString().toDouble();
            val result = peso / (altura * altura)
            if (result < 19) {
                total.setText(" Abaixo do peso, IMC = " + result);
            } else if (result <= 19 || result < 25) {
                total.setText(" Peso normal, IMC = " + result);
            } else if (result <= 25 || result < 30) {
                total.setText(" Sobrepeso, IMC = " + result);
            } else if (result <= 30 || result < 40) {
                total.setText(" Obesidade tipo 1, IMC = " + result);
            } else if (result >= 40) {
                total.setText(" Obesidade tipo 2, IMC = " + result);
            }
        }
        voltar.setOnClickListener {
            Intent(this, MainActivity::class.java)
            finish()
        }
    }
}