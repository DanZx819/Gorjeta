package com.example.gorjeta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gorjeta.databinding.ActivityMainBinding
import com.example.gorjeta.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resultado1 = intent.getFloatExtra("resultado1", 0.0f)
        val resultado2 =  intent.getFloatExtra("resultado2", 0.0f)
        val resultado3 = intent.getFloatExtra("resultado3", 0.0f)
        val porcentagem = intent.getIntExtra("Porcentagem", 0)
        val Total = intent.getFloatExtra("Total", 0.0f)

        val formattedTotal = String.format("%.2f", Total)
        val formattedRes1 = String.format("%.2f", resultado1)
        val formattedRes2 = String.format("%.2f", resultado2)
        val formattedRes3 = String.format("%.2f", resultado3)
        val formattedPorcentagem = String.format("%d", porcentagem)

        val tvPorcentagem = findViewById<TextView>(R.id.tv_pocentagem)
        val tvTotal = findViewById<TextView>(R.id.tvtotal)
        val tvPessoas = findViewById<TextView>(R.id.tv_porpessoa)
        val tvGorjetapp = findViewById<TextView>(R.id.tv_gorjetapp)
        val tvGorjetatotal = findViewById<TextView>(R.id.tv_gorjeta_total)
        val BtnNovo = findViewById<Button>(R.id.btn_novo_calculo)

        tvPorcentagem.text = "${formattedPorcentagem}%"
        tvTotal.text = "R$${formattedTotal}"
        tvPessoas.text = "R$${formattedRes1}"
        tvGorjetapp.text = "R$${formattedRes2}"
        tvGorjetatotal.text = "R$${formattedRes3}"

       BtnNovo.setOnClickListener(){
            finish()
        }
    }
}