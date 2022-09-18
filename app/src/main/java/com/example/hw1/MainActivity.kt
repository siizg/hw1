package com.example.hw1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw1.ui.theme.Hw1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Hw1Theme {
                Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                    var number = rememberSaveable() {
                        mutableStateOf(0)
                    }
                    Spacer(modifier = Modifier.height(256.dp))
                    Text(text = "${number.value}")
                    Spacer(modifier = Modifier.height(64.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Spacer(modifier = Modifier.width(32.dp))
                        OutlinedButton(onClick = {number.value++}) {
                            Text(text = "+1", color = Color.Blue)
                        }
                        Spacer(modifier = Modifier.width(32.dp))
                        OutlinedButton(onClick = {number.value--}) {
                            Text(text = "-1", color = Color.Blue)
                        }
                        Spacer(modifier = Modifier.width(32.dp))
                        OutlinedButton(onClick = {number.value *= 2}) {
                            Text(text = "*2", color = Color.Blue)
                        }
                        Spacer(modifier = Modifier.width(32.dp))
                        var context = LocalContext.current

                        OutlinedButton(onClick = {
                            if(number.value % 3 == 0) {
                                number.value /= 3
                            }
                            else Toast.makeText(context, "Нельзя поделить!", Toast.LENGTH_SHORT).show()
                            }) {
                            Text(text = "/3", color = Color.Blue)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
@Composable
fun makeToast(text : String) {
    Toast.makeText(LocalContext.current, text, Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Hw1Theme {
        Greeting("Android")
    }
}
