package com.example.laba3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var inputString: EditText
    private lateinit var inputChar: EditText
    private lateinit var findButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputString = findViewById(R.id.inputString)
        inputChar = findViewById(R.id.inputChar)
        findButton = findViewById(R.id.findButton)
        resultTextView = findViewById(R.id.resultTextView)

        findButton.setOnClickListener { findLastChar() }
    }

    private fun findLastChar() {
        val str = inputString.text.toString()
        val char = inputChar.text.toString()

        if (str.isNotEmpty() && char.length == 1) {
            val lastIndex = str.lastIndexOf(char[0])
            if (lastIndex != -1) {
                resultTextView.text = "Номер последнего символа '$char': ${lastIndex + 1}" // +1 для 1-индексации
            } else {
                resultTextView.text = "Символ '$char' не найден."
            }
        } else {
            resultTextView.text = "Введите корректную строку и символ."
        }
    }
}