package com.example.gorjeta

import android.annotation.SuppressLint
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

        val edtPreco = findViewById<TextInputEditText>(R.id.edt_preco)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val btnCalc = findViewById<Button>(R.id.btn_calc)
        val tvResult2 = findViewById<TextView>(R.id.tv_result2)
        val btnReset = findViewById<Button>(R.id.btn_reset)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.num_people,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPeople.adapter = adapter

        var num_people = 0
        binding.spinnerPeople.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long)
            {
                num_people = position
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        var percentage: Int = 0
        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 10
            }
        }
        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 15
            }
        }
        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 20
            }
        }



        btnCalc.setOnClickListener() {
            val StrPreco = edtPreco.text.toString()


            if (StrPreco.isNotEmpty()  ) {
                val flPreco = StrPreco.toFloat()

                val resultado1 = flPreco / num_people
                val resultado2 = (resultado1 * percentage) / 100
                val resultado3 = (flPreco * percentage / 100)
                tvResult.text = "R$%.2f".format(resultado1)
                tvResult2.text = "R$%.2f".format(resultado2)
                binding.tvResult3.text = "R$%.2f".format(resultado3)
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
            tvResult.text = "R$0,00"
            tvResult2.text = "R$0,00"

            binding.edtPreco.setText("")
            binding.tvResult3.text = "R$0,00"
            binding.rbOptionOne.isChecked = false
            binding.rbOptionTwo.isChecked = false
            binding.rbOptionThree.isChecked = false
        }
    }
}