package com.example.hello_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtext =findViewById<EditText>(R.id.texta1)
        val buttonG =findViewById<RadioGroup>(R.id.radio1)
        val generateButton =findViewById<Button>(R.id.button11)

        generateButton.setOnClickListener{
            val textbox=edtext.text.toString()

            val checkButtonID=buttonG.checkedRadioButtonId
            var selectedText=""
            if(checkButtonID != -1) {
                val selectedButton = findViewById<RadioButton>(checkButtonID)
                selectedText = selectedButton.text.toString()

            }
            if(textbox.isNotEmpty() && selectedText.isNotEmpty()){
                val calc=AppCalc(textbox,selectedText)

                val resultText=calc.output()
                Toast.makeText(this,"出力結果:$resultText",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"市民証をみて年齢でクレーム。",Toast.LENGTH_LONG).show()
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}