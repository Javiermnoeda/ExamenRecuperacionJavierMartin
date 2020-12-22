package com.example.examenrecuperacionjaviermartin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random as Random
/*
Crea una aplicación en android y kotlin que:

a) La primera Activity se se compone de 3 botones (Duplicar (desactivado), Añadir Numero, Siguiente (desactivado) y un textview) HECHO
b) cada vez que el usuario presione el boton duplicar, el textview duplica su contenido en modo inverso, por ejemplo, si tiene 1234, el resultado sera 12344321
c) Cada vez que el usuario presione el boton Añadir numero, el text view muestra el texto que tuviera mas un numero aleatorio
d) Cuando el usuario pulsa el botón siguiente, se abre una segunda activity. (1 punto) HECHO!!


 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val button1 = findViewById<Button>(R.id.botonañadir)
        val button2 = findViewById<Button>(R.id.botonDuplicar)
        val button3 = findViewById<Button>(R.id.botonsiguiente)


        //Añadir numero
        button1.setOnClickListener {
            textView.text= "${Random.nextInt((5000-1000)) + 1000}"
            button2.isEnabled = it.isClickable
            button3.isEnabled = it.isClickable
        }

        val texto = textView.text.toString()

        button2.setOnClickListener {
            texto?.let {
                textView.setText(texto.reversed())
            }
        }


        button3.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        fun Random( length: Int ){

            val sb = StringBuilder(length)

            val alphabet = "5000"

            val rand = Random
            for ( i in 0 until sb.capacity() ) {

                val index = rand.nextInt( alphabet.length )
                sb.append( alphabet[ index ] )
            }

        }



    }

}


