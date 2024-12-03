package com.example.gorjeta

import android.os.Bundle
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
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resultado1 = intent.getFloatExtra("resultado1", 0.0f)
        val resultado2 =  intent.getFloatExtra("resultado2", 0.0f)
        val resultado3 = intent.getFloatExtra("resultado3", 0.0f)
        val Total = intent.getFloatExtra("Total", 0.0f)

        val StrTotal = Total.toString()
        val StrRes1 = resultado1.toString()
        val StrRes2 = resultado2.toString()
        val StrRes3 = resultado3.toString()

        val tvTotal = findViewById<TextView>(R.id.tvtotal)
        val tvPessoas = findViewById<TextView>(R.id.tv_porpessoa)
        val tvGorjetapp = findViewById<TextView>(R.id.tv_gorjetapp)
        val tvGorjetatotal = findViewById<TextView>(R.id.tv_gorjeta_total)



        tvTotal.text = "R$${StrTotal}"
        tvPessoas.text = "R$${StrRes1}"
        tvGorjetapp.text = "R$${StrRes2}"
        tvGorjetatotal.text = "R$${StrRes3}"

    }
}