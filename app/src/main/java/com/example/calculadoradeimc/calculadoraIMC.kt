package com.example.calculadoradeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoradeimc.databinding.ActivityCalculadoraImcBinding

class calculadoraIMC : AppCompatActivity() {
    private lateinit var binding: ActivityCalculadoraImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

     binding.buttonBackIMC.setOnClickListener {
         val VoltarTelaPrincipal = Intent(this,MainActivity::class.java)
         startActivity(VoltarTelaPrincipal)
     }   

    }





}
