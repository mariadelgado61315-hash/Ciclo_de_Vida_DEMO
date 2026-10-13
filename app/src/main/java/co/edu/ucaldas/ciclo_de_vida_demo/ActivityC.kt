package co.edu.ucaldas.ciclo_de_vida_demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityC : AppCompatActivity() {

    private val TAG = "CicloDeVida"
    private var contadorLocal = 0
    private lateinit var tvValorC: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        Log.d(TAG, "ActivityC -> onCreate - Hash: ${this.hashCode()}")

        contadorLocal = intent.getIntExtra("contador", 0)

        tvValorC = findViewById(R.id.tvValorC)
        val btnSumar = findViewById<Button>(R.id.btnSumarC)
        val btnRestar = findViewById<Button>(R.id.btnRestarC)
        val btnGuardarVolver = findViewById<Button>(R.id.btnGuardarVolver)

        actualizarValor()

        btnSumar.setOnClickListener {
            contadorLocal++
            actualizarValor()
        }

        btnRestar.setOnClickListener {
            contadorLocal--
            actualizarValor()
        }

        btnGuardarVolver.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("contador_actualizado", contadorLocal)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun actualizarValor() {
        tvValorC.text = "Valor editable en C: $contadorLocal"
    }

    override fun onStart() { super.onStart(); Log.d(TAG, "ActivityC -> onStart - Hash: ${this.hashCode()}") }
    override fun onResume() { super.onResume(); Log.d(TAG, "ActivityC -> onResume - Hash: ${this.hashCode()}") }
    override fun onPause() { super.onPause(); Log.d(TAG, "ActivityC -> onPause - Hash: ${this.hashCode()}") }
    override fun onStop() { super.onStop(); Log.d(TAG, "ActivityC -> onStop - Hash: ${this.hashCode()}") }
    override fun onRestart() { super.onRestart(); Log.d(TAG, "ActivityC -> onRestart - Hash: ${this.hashCode()}") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "ActivityC -> onDestroy - Hash: ${this.hashCode()}") }
}