package com.example.gorjeta

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gorjeta.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtpercentage = findViewById<TextInputEditText>(R.id.edt_percentage)
        val edtPessoas = findViewById<TextInputEditText>(R.id.edt_pessoas)
        val edtPreco = findViewById<TextInputEditText>(R.id.edt_preco)
        val btnCalc = findViewById<Button>(R.id.btn_calc)
        val btnReset = findViewById<Button>(R.id.btn_reset)






        btnCalc.setOnClickListener() {
            val StrPreco = edtPreco.text.toString()
            val StrPessoas = edtPessoas.text.toString()
            val StrPercentage = edtpercentage.text.toString()
            if (StrPreco.isNotEmpty() && StrPessoas.isNotEmpty() && StrPercentage.isNotEmpty()) {
                val flPreco = StrPreco.toFloat()
                val num_people = StrPessoas.toInt()
                val percentage = StrPercentage.toInt()

                val resultado1 = flPreco / num_people
                val resultado2 = (resultado1 * percentage) / 100
                val resultado3 = (flPreco * percentage / 100)

                val intent = Intent(this, ResultadoActivity::class.java )
                intent.apply {
                    putExtra("resultado1", resultado1)
                    putExtra("resultado2", resultado2)
                    putExtra("resultado3", resultado3)
                    putExtra("Total", flPreco)
                    putExtra("Porcentagem", percentage)
                }
                clean()
                startActivity(intent)

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
            clean()
        }


    }
    private fun clean(){
        binding.edtPreco.setText("")
        binding.edtPessoas.setText("")
        binding.edtPercentage.setText("")
    }
}