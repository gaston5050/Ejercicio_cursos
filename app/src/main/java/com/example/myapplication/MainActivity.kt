package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Datos
import com.example.myapplication.model.Topic
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {

                    var lista = Datos.pasaListado()
                    listadora(listaTopic = lista)


            }
        }
    }
}



@Composable
fun Tarjeta_layout(topic: Topic, modifier: Modifier = Modifier) {

    Card(modifier = Modifier
        .fillMaxWidth()) {
        Row {
            Column() {
                Image(
                    modifier = Modifier
                        .height(68.dp)
                        .width(68.dp),
                    painter = painterResource(id = topic.imagenTopic),
                    contentDescription = null
                )

            }
            Column(modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp)) {
                Text(
                    text = stringResource(topic.textoTopic),



                )
                Column() {

                    Row {
                        Image(
                            painter = painterResource(R.drawable.ic_grain),
                            contentDescription = null
                        )


                        Text(
                            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                            text = topic.cantidad.toString()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun listadora(listaTopic: List<Topic>) {


    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(top=30.dp,start=10.dp,end=10.dp),
        verticalArrangement =Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),

    ){
        items(listaTopic.size) { idCurso ->
            Tarjeta_layout(topic = listaTopic[idCurso])
        }


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        var lista = Datos.pasaListado()
        listadora(listaTopic = lista)

    }
}