package com.example.myapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        val nombre = intent.getStringExtra("EXTRA_NOMBRE") ?: ""
        val edad = intent.getStringExtra("EXTRA_EDAD") ?: ""

        tvSaludo.text = if (edad.isNotBlank()) {
            "Hola $nombre, tienes $edad años"
        } else {
            "Hola $nombre"
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
}

