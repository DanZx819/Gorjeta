package com.example.gorjeta

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPreco = findViewById<TextInputEditText>(R.id.edt_preco)
        val edtPessoas = findViewById<TextInputEditText>(R.id.edt_pessoas)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val btnCalc = findViewById<Button>(R.id.btn_calc)
        val edtGorjeta = findViewById<TextInputEditText>(R.id.edt_gorjeta)
        val tvResult2 = findViewById<TextView>(R.id.tv_result2)
        val btnReset = findViewById<Button>(R.id.btn_reset)


        btnCalc.setOnClickListener() {
            val StrPreco = edtPreco.text.toString()
            val StrPessoas = edtPessoas.text.toString()
            val StrGorjeta = edtGorjeta.text.toString()
            if (StrPreco.isNotEmpty() && StrPessoas.isNotEmpty() && StrGorjeta.isNotEmpty()) {
                val flPreco = StrPreco.toFloat()
                val flPessoas = StrPessoas.toFloat()
                val flGorjeta = StrGorjeta.toFloat()
                val resultado1 = flPreco / flPessoas
                val resultado2 = (resultado1 * flGorjeta) / 100
                tvResult.text = "R$%.2f".format(resultado1)
                tvResult2.text = "R$%.2f".format(resultado2, flGorjeta)
            } else {
                Snackbar
                    .make(
                        edtPreco,
                        "Digite os valores no campo acima",
                        Snackbar.LENGTH_LONG
                    ).show()
            }

        }
        btnReset.setOnClickListener() {
            tvResult.text = ""
            tvResult2.text = ""
        }

    }
}