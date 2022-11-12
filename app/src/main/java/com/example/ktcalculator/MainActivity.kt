package com.example.ktcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ktcalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting functions to key in calculator to manipulate display area
        // such as, pressing a no shows it in display
        // or, AC button clears display areas
        binding.btnAc.setOnClickListener() {
            binding.tvInputTextDisplay.text = ""
            binding.tvOutputTextDisplay.text = ""
        }

        binding.btnStartBracket.setOnClickListener() {
            binding.tvInputTextDisplay.append("(")
        }

        binding.btnEndBracket.setOnClickListener() {
            binding.tvInputTextDisplay.append(")")
        }

        binding.btnDivide.setOnClickListener() {
            binding.tvInputTextDisplay.append("/")
        }



        binding.btn7.setOnClickListener() {
            binding.tvInputTextDisplay.append("7")
        }

        binding.btn8.setOnClickListener() {
            binding.tvInputTextDisplay.append("8")
        }

        binding.btn9.setOnClickListener() {
            binding.tvInputTextDisplay.append("9")
        }

        binding.btnMultiply.setOnClickListener() {
            binding.tvInputTextDisplay.append("*")
        }




        binding.btn4.setOnClickListener() {
            binding.tvInputTextDisplay.append("4")
        }

        binding.btn5.setOnClickListener() {
            binding.tvInputTextDisplay.append("5")
        }

        binding.btn6.setOnClickListener() {
            binding.tvInputTextDisplay.append("6")
        }

        binding.btnSubtract.setOnClickListener() {
            binding.tvInputTextDisplay.append("-")
        }




        binding.btn1.setOnClickListener() {
            binding.tvInputTextDisplay.append("1")
        }

        binding.btn2.setOnClickListener() {
            binding.tvInputTextDisplay.append("2")
        }

        binding.btn3.setOnClickListener() {
            binding.tvInputTextDisplay.append("3")
        }

        binding.btnAdd.setOnClickListener() {
            binding.tvInputTextDisplay.append("+")
        }






        binding.btn0.setOnClickListener() {
            binding.tvInputTextDisplay.append("0")
        }

        binding.btnDecimal.setOnClickListener() {
            binding.tvInputTextDisplay.append(".")
        }

        binding.btnEqual.setOnClickListener() {
            // do not show EQUAL SIGN insted calculate on click
            // binding.tvInputTextDisplay.append("=")

            // TO EVALUATE using ExpressionBuilder().build()
            //you need to import dependency
            // by adding a line in "build gradle(app>Gradle Scripts> build.gradle(Module:app)"  in 'dependencies{ }'
            // implementation 'net.objecthunter:exp4j:0.4.8'

            val text = binding.tvInputTextDisplay.text.toString()
            val expression = ExpressionBuilder(text).build()
            val result = expression.evaluate()
            val longresult = result.toLong()

            if (result == longresult.toDouble()) {
                binding.tvOutputTextDisplay.text = longresult.toString()
            }
            else {
                binding.tvOutputTextDisplay.text = result.toString()
            }

        }
    }
}