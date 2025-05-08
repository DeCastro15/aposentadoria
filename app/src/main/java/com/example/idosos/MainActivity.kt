package com.example.idosos

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.R
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idosos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf("masculino", "feminino")
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, items)

        binding.spinnerSexo.adapter= adapter

        binding.buttonCalcular.setOnClickListener{
            val sexoSelecionado = binding.spinnerSexo.selectedItem as String
            var  idade = binding.textIdade.text.toString().toLong()
            var resultado:Long = 0

            if (idade!= null) {
                if (sexoSelecionado.trim() == "masculino") {
                    resultado = idade - 65
                } else {
                    resultado = idade - 62
                }
                binding.textViewResultado.text = "Faltam $resultado anos para você se aposentar"
            }else{
                binding.textViewResultado.text = "O campo idade deve ser preenchido"
            }
        }

    }
}

