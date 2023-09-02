package com.example.calculadoradeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.calculadoradeimc.databinding.ActivityCalculadoraImcBinding

class calculadoraIMC : AppCompatActivity() {
    private lateinit var binding: ActivityCalculadoraImcBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_imc)


        val peso = findViewById(R.id.editPeso) as EditText
        val altura = findViewById(R.id.editAltura) as EditText
        val total = findViewById(R.id.textResultado) as TextView
        val calcular = findViewById(R.id.buttonCalcular) as Button
        val voltar = findViewById(R.id.button_back_IMC) as Button


        calcular.setOnClickListener {
            val peso = peso.text.toString().toDouble();
            val altura = altura.text.toString().toDouble();

            val result = peso / (altura * altura)

            total.setText(result.toString())

        }
        voltar.setOnClickListener {
            val VoltarTelaPrincipal = Intent(this, MainActivity::class.java)
                 startActivity(VoltarTelaPrincipal)
        }


        
        }

    }


//}
