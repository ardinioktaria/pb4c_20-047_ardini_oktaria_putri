package com.example.tugaspendahuluan4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tombol = findViewById<Button>(R.id.button1)
        tombol.setOnClickListener {
            Toast.makeText(applicationContext, "Berhasil", Toast.LENGTH_SHORT).show()
        }
        val radio1 = findViewById<RadioButton>(R.id.RB1)
        radio1.setOnClickListener {
            Toast.makeText(applicationContext, "Anda Memilih Es Campur", Toast.LENGTH_SHORT).show()
        }
        val radio2 = findViewById<RadioButton>(R.id.RB2)
        radio2.setOnClickListener {
            Toast.makeText(applicationContext, "Anda Memilih Es Teh", Toast.LENGTH_SHORT).show()
        }
        val box1 = findViewById<CheckBox>(R.id.CB1)
        box1.setOnClickListener {
            Toast.makeText(applicationContext, "Anda Memilih Risol Mayo", Toast.LENGTH_SHORT).show()
        }
        val box2 = findViewById<CheckBox>(R.id.CB2)
        box2.setOnClickListener {
            Toast.makeText(applicationContext, "Anda Memilih Donat", Toast.LENGTH_SHORT).show()
        }


    }
}