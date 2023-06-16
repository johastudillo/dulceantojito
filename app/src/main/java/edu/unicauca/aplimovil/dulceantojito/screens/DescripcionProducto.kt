package edu.unicauca.aplimovil.dulceantojito.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.aplimovil.dulceantojito.R
import edu.unicauca.aplimovil.dulceantojito.navigation.AppScreens

//funcion que muestra la pantalla
@Composable
fun DescripcionProducto(navController: NavController){
    Scaffold(topBar = {
        //boton volver
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back", modifier = Modifier.clickable {
                    //volver
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Volver")
        }
    }){
        ProductDescriptionScreen(navController)
    }

}
//funcion del cuerpo de la pantalla
@Composable
fun ProductDescriptionScreen(navController: NavController
) {
    var cantidad by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //imagen del producto 1
        Image(
            painter = painterResource(R.drawable.product1),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )
        //nombre del producto
        Text(
            text = "Hamburguesa",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        //descripcion del producto
        Text(
            text = "Dos carnes de 165 g cada una de res a la parrilla, cebollitas crunchy, queso mozzarella, verduras y salsa todoterreno en pan artesano + papas medianas (corral o cascos) + bebida",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(bottom = 8.dp),
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
        //texto precio
        Text(
            text = "Precio: $ 45.800,00",
            style = MaterialTheme.typography.body2
        )

        //campo para llenar la cantidad
        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text(text = "Cantidad") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        //boton para navegar a la canasta
        Button(onClick = {
            /* Lógica */
            //ruta para dirigirse a la pantalla de la canasta y enviar un parametro
            navController.navigate(route = AppScreens.Canasta.route + "/"+cantidad)
        }) {
            Text("ordenar")
        }

    }
}

