package co.edu.ucaldas.ciclo_de_vida_demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    private val TAG = "CicloDeVida"
    private var contadorRecibido = 10
    private lateinit var tvDetalleB: TextView

    private val launcherC = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { resultado ->
        if (resultado.resultCode == RESULT_OK) {
            val nuevoValor = resultado.data?.getIntExtra("contador_actualizado", contadorRecibido) ?: contadorRecibido
            contadorRecibido = nuevoValor
            tvDetalleB.text = "Valor devuelto desde C: $contadorRecibido"
            Log.d(TAG, "ActivityB -> Recibió de vuelta el contador modificado: $contadorRecibido")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        Log.d(TAG, "ActivityB -> onCreate - Hash: ${this.hashCode()}")

        val nombre = intent.getStringExtra("nombre_usuario") ?: "Sin Nombre"
        tvDetalleB = findViewById(R.id.tvDetalleB)
        tvDetalleB.text = "Bienvenido $nombre. Contador: $contadorRecibido"

        val btnIrC = findViewById<Button>(R.id.btnIrC)
        btnIrC.setOnClickListener {
            val intentC = Intent(this, ActivityC::class.java)
            intentC.putExtra("contador", contadorRecibido)
            launcherC.launch(intentC)
        }
    }

    override fun onStart() { super.onStart(); Log.d(TAG, "ActivityB -> onStart - Hash: ${this.hashCode()}") }
    override fun onResume() { super.onResume(); Log.d(TAG, "ActivityB -> onResume - Hash: ${this.hashCode()}") }
    override fun onPause() { super.onPause(); Log.d(TAG, "ActivityB -> onPause - Hash: ${this.hashCode()}") }
    override fun onStop() { super.onStop(); Log.d(TAG, "ActivityB -> onStop - Hash: ${this.hashCode()}") }
    override fun onRestart() { super.onRestart(); Log.d(TAG, "ActivityB -> onRestart - Hash: ${this.hashCode()}") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "ActivityB -> onDestroy - Hash: ${this.hashCode()}") }
}