package com.hugorafaelcosta.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hugorafaelcosta.calculadoradenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {


            val num1 = binding.editTextNota1
            val num2 = binding.editTextNota2
            val num3 = binding.editTextNota3
            val num4 = binding.editTextNota4
            val faltas = binding.editTextNumeroDeFaltas
            val resultado = binding.txtResultado

            val nota1 = Integer.parseInt(num1.text.toString())
            val nota2 = Integer.parseInt(num2.text.toString())
            val nota3= Integer.parseInt(num3.text.toString())
            val nota4 = Integer.parseInt(num4.text.toString())
            val numeroDeFaltas = Integer.parseInt(faltas.text.toString())


            val media = (nota1+nota2+nota3+nota4) / 4
            when {
                media >= 5 && numeroDeFaltas <= 20 -> {
                    resultado.text = "Aluno aprovado \n Média final $media"
                    resultado.setTextColor(getColor(R.color.green))
                }
                numeroDeFaltas > 20 -> {
                    resultado.text = "Aluno reprovado por faltas \n Media Final $media"
                    resultado.setTextColor(getColor(R.color.red))
                }
                else -> {
                    resultado.text = "Aluno reprovado por Nota \n Media Final $media"
                    resultado.setTextColor(getColor(R.color.red))
                }
            }

        }
    }
}