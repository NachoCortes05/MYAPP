package com.example.miprimeraapp   // cambia esto por el package real de cada proyecto

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class SecondActivity : ComponentActivity() {

    private var reproductor: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textoSaludo = findViewById<TextView>(R.id.textoSaludoPersonalizado)
        val imagenResultado = findViewById<ImageView>(R.id.imagenResultado)
        val botonVolver = findViewById<Button>(R.id.botonVolver)

        val nombre = intent.getStringExtra("NOMBRE_EXTRA") ?: "invitado"
        val edadTexto = intent.getStringExtra("EDAD_EXTRA") ?: "0"
        val edad = edadTexto.toIntOrNull() ?: 0

        textoSaludo.text = "Hola, $nombre, tienes $edad años"

        val sonidoId: Int
        when {
            edad < 12 -> {
                imagenResultado.setImageResource(R.drawable.foto_arbol)
                sonidoId = R.raw.sonido_nino
            }
            edad < 18 -> {
                imagenResultado.setImageResource(R.drawable.foto_pantera)
                sonidoId = R.raw.sonido_adolescente
            }
            else -> {
                imagenResultado.setImageResource(R.drawable.foto_pantera)
                sonidoId = R.raw.sonido_adulto
            }
        }

        reproductor = MediaPlayer.create(this, sonidoId)
        reproductor?.start()

        botonVolver.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        reproductor?.release()
        reproductor = null
    }
}
