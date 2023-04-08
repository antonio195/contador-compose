package br.com.antoniocostadossantos.contadorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.antoniocostadossantos.contadorcompose.ui.theme.ContadorComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContadorComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Contador()
                }
            }
        }
    }
}

@Composable
fun Contador() {
    val contador: MutableState<Int> = remember { mutableStateOf(0) }

    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = {
                contador.value++
                println("Clicouu")
            },
        ) {
            Icon(Icons.Filled.Add, "")
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Contador: ${contador.value}", fontSize = 25.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ContadorComposeTheme {
        Contador()
    }
}