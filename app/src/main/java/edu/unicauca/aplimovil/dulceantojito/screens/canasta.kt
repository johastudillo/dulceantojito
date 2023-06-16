package edu.unicauca.aplimovil.dulceantojito.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.aplimovil.dulceantojito.R
import edu.unicauca.aplimovil.dulceantojito.navigation.AppScreens
//funcion que muestra la pantalla
@Composable
fun Canasta(navController: NavController, text: String?){
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back", modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Volver")
        }
    }){
        canastascren(navController, text)
    }

}

//funcion del cuerpo de la pantalla
@Composable
fun canastascren( navController: NavController, text: String?){
    var cantInt by mutableStateOf(0)
    var cantStr by mutableStateOf("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //titulo
        Text(text = "Canasta", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
         //imagen de la cansta
        Image(
            painter = painterResource(R.drawable.canasta), // Reemplaza "my_image" con el nombre de tu imagen en el directorio "res/drawable"
            contentDescription = "Imagen",
            modifier = Modifier.size(100.dp)
            //modifier = Modifier.fillMaxSize()
        )
        //imprime lista pero de un solo producto
        //imprime nombre, imagen y precio
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(productList) { product ->
                canitem(product, navController)

            }
        }
        //imprime TEXTO, y la cantidad escogidad
        Text(text = "Cantidad", style = MaterialTheme.typography.h6)
        //cantidad escogida
        text?.let {
            Text(it)
        }

        //boton para comprar
        Button(onClick = {
            /* Lógica */
            text?.let {
                //asigno a cantStr lo cantidad que se escogio
                cantStr = text
                //covertimos CanStr a nunmerico y lo asignamos a cantInt
                cantInt = cantStr.toInt()
                //operacion
                cantInt = cantInt*45800
            }

        }) {
            Text("realizar compra")
        }

        //imprime valor calculado
        Text(
            text = "Compra Exitosa: $cantInt",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(16.dp)
        )
    }

}

//funcion para imprimir un solo producto
@Composable
fun canitem(product: Product, navController: NavController){
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // si id es == 1
        if(product.id.equals(1)) {
            Image(
                painter = painterResource(id = product.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Text("Nombre Producto: ${product.name} ")
            Spacer(modifier = Modifier.height(16.dp))
            Text("Price: $${product.price}")
        }
    }
}


