package proyectoa.com.botonfuncionjetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import proyectoa.com.botonfuncionjetpackcompose.MainActivity.Companion.TEXTO_TITULO
import proyectoa.com.botonfuncionjetpackcompose.ui.theme.TemaProyectoA

class MainActivity : ComponentActivity() {
    companion object {
        // Constante para el texto que se muestra arriba
        const val TEXTO_TITULO = "Mostrar botón - ProyectoA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Usamos el tema visual definido en el fichero ui.theme\Theme.kt
            TemaProyectoA {
                // Contenedor que usa el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Mostramos los elementos gráficos
                    // Pasamos como parámetro el texto, el color, el estilo y la
                    // función que se asignará al onClick del botón
                    DibujarEntorno(
                        texto = TEXTO_TITULO,
                        color = MaterialTheme.colorScheme.primary,
                        estilo = MaterialTheme.typography.titleLarge
                    ) { funcinoBotonEjemplo() }
                }
             }
        }
    }

    // Definimos la función que se asignará al evento onClick del botón
    private fun funcinoBotonEjemplo() {
        // Mostramos un mensaje Toast para indicar que se ha ejecutado la función
        Toast.makeText(this, "Has pulsado el botón Prueba", Toast.LENGTH_SHORT).show()
        // Mostramos un texto en Logcat de Android Studio para depurar y comprobar que se ha ejecutado
        Log.d("ProyectoA", "Función ejecutada")
    }
}

// Dibujamos todo el entorno visual (texto y botón)
@Composable
fun DibujarEntorno(texto: String,
                   color: Color = MaterialTheme.colorScheme.primary,
                   estilo: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.titleMedium,
                   onClickBoton: () -> Unit) {
    // Usamos Column para distrubir el texto encima del botón
    Column(modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Texto(texto, color, estilo)
        BtPrueba(onClickBoton)
    }
}

// Dibujamos un texto
@Composable
fun Texto(texto: String, color: Color, estilo: androidx.compose.ui.text.TextStyle) {
    Text(
        text = texto,
        color = color,
        style = estilo
    )
}

// Dibujamos un botón
@Composable
fun BtPrueba(onClickBoton: () -> Unit) {
    Button(onClick = onClickBoton) {
        Text("Prueba")
    }
}

// Para previsualizar la vista
@Preview(showBackground = true)
@Composable
fun DibujarEntornoPreview() {
    TemaProyectoA {
        DibujarEntorno(
            texto = TEXTO_TITULO,
            color = MaterialTheme.colorScheme.primary,
            estilo = MaterialTheme.typography.titleMedium
        ) {  }
    }
}