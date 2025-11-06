package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tarjeta_layout(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}




@Composable
fun Tarjeta_layout(name: String, modifier: Modifier = Modifier) {

    Card(modifier= Modifier.fillMaxWidth().padding(16.dp)){
    Row{
        Column(){
            Image(modifier= Modifier.height(68.dp).width(68.dp),
                painter = painterResource(id = R.drawable.film),
                contentDescription = null
            )

        }
        Column(modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)){
            Text(
                text = stringResource( R.string.business)

            )
            Column(){

               Row{
                   Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null
                    )


                   Text(
                       modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                       text = stringResource( R.string.film)
                   )
               }
            }
        }
    }
    }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Tarjeta_layout("Android")
    }
}