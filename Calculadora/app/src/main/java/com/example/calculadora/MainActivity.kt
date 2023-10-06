package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var numeroActual = ""
    var numeroAnterior = ""
    var operacionPendiente = ""
    var resultado = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtMostrarRta: TextView = findViewById(R.id.txtMostrarRta)

        // Botones numéricos
        val btnCero: Button = findViewById(R.id.btnCero)
        val btnUno: Button = findViewById(R.id.btnUno)
        val btnDos: Button = findViewById(R.id.btnDos)
        val btnTres: Button = findViewById(R.id.btnTres)
        val btnCuatro: Button = findViewById(R.id.btnCuatro)
        val btnCinco: Button = findViewById(R.id.btnCinco)
        val btnSeis: Button = findViewById(R.id.btnSeis)
        val btnSiete: Button = findViewById(R.id.btnSiete)
        val btnOcho: Button = findViewById(R.id.btnOcho)
        val btnNueve: Button = findViewById(R.id.btnNueve)

        // Botón de suma
        val btnSumar: Button = findViewById(R.id.btnSumar)
        btnSumar.setOnClickListener {
            realizarOperacion()
            operacionPendiente = "+"
            txtMostrarRta.text = ""
        }

        // Botón de resta
        val btnRestar: Button = findViewById(R.id.btnRestar)
        btnRestar.setOnClickListener {
            realizarOperacion()
            operacionPendiente = "-"
            txtMostrarRta.text = ""
        }

        // Botón de multiplicar
        val btnMultiplicar: Button = findViewById(R.id.btnMultiplicar)
        btnMultiplicar.setOnClickListener {
            realizarOperacion()
            operacionPendiente = "*"
            txtMostrarRta.text = ""
        }

        // Botón de dividir
        val btnDividir: Button = findViewById(R.id.btnDividir)
        btnDividir.setOnClickListener {
            realizarOperacion()
            operacionPendiente = "/"
            txtMostrarRta.text = ""
        }

        // Botón de igual
        val btnIgual: Button = findViewById(R.id.btnIgual)
        btnIgual.setOnClickListener {
            realizarOperacion()
            txtMostrarRta.text = resultado.toString()
        }

        // Botón de reset
        val btnResetear: Button = findViewById(R.id.btnResetear)
        btnResetear.setOnClickListener {
            reset()
            txtMostrarRta.text = ""
        }

        // Listener para los botones numéricos
        val btnsNumericos = listOf(btnCero, btnUno, btnDos, btnTres, btnCuatro, btnCinco ,btnSeis, btnSiete,btnOcho,btnNueve)
        for (btn in btnsNumericos) {
            btn.setOnClickListener {
                agregarNumero(btn.text.toString())
                txtMostrarRta.append(btn.text)
            }
        }
    }

    fun agregarNumero(numero: String) {
        numeroActual += numero
    }

    fun realizarOperacion() {
        if (numeroActual.isNotEmpty()) {
            if (numeroAnterior.isNotEmpty()) {
                when (operacionPendiente) {
                    "+" -> resultado = numeroAnterior.toDouble() + numeroActual.toDouble()
                    "-" -> resultado = numeroAnterior.toDouble() - numeroActual.toDouble()
                    "*" -> resultado = numeroAnterior.toDouble() * numeroActual.toDouble()
                    "/" -> resultado = numeroAnterior.toDouble() / numeroActual.toDouble()
                }
            } else {
                resultado = numeroActual.toDouble()
            }
            numeroAnterior = numeroActual
            numeroActual = ""
        }
    }

    fun reset() {
        numeroActual = ""
        numeroAnterior = ""
        operacionPendiente = ""
        resultado = 0.0
    }
}
