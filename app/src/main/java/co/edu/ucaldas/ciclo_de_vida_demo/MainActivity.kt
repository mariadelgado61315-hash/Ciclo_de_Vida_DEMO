package co.edu.ucaldas.ciclo_de_vida_demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "CicloDeVida"
    private var contadorActual = 0
    private lateinit var tvContador: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity -> onCreate - Hash: ${this.hashCode()}")

        if (savedInstanceState != null) {
            contadorActual = savedInstanceState.getInt("contador", 0)
            Log.d(TAG, "MainActivity -> Estado restaurado. Contador = $contadorActual")
        }

        tvContador = findViewById(R.id.tvContadorA)
        val btnIncrementar = findViewById<Button>(R.id.btnIncrementarA)
        val btnNavegarB = findViewById<Button>(R.id.btnNavegarB)

        actualizarUI()

        btnIncrementar.setOnClickListener {
            contadorActual++
            actualizarUI()
        }

        btnNavegarB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            intent.putExtra("nombre_usuario", "Estudiante UCaldas")
            startActivity(intent)
        }
    }

    private fun actualizarUI() {
        tvContador.text = "Contador en ActivityA: $contadorActual"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contadorActual)
        Log.d(TAG, "MainActivity -> onSaveInstanceState guardando contador: $contadorActual")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity -> onStart - Hash: ${this.hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity -> onResume - Hash: ${this.hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity -> onPause - Hash: ${this.hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity -> onStop - Hash: ${this.hashCode()}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity -> onRestart - Hash: ${this.hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity -> onDestroy - Hash: ${this.hashCode()}")
    }
}