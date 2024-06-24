package com.example.imc20

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imc20.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val bundle = intent.extras
        if (bundle != null){
            val height = bundle.getDouble("height")
            val weight = bundle.getDouble("weight")
            binding.textHeight.text = "Reported weight $weight KG"
            binding.textWeight.text = "Reported height $height M"

             val imc = weight / (height * height)
             val result = if (imc < 18.5){
                "Low"
            }else if (imc in 18.5..24.9){
                "Normal"
            }else if (imc in 25.0..29.9){
                "Overweight"
            }else{
                "Obese"
            }
            binding.textResult.text  = result
        }
    }
}