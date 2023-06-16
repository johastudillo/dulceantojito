package edu.unicauca.aplimovil.dulceantojito.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.aplimovil.dulceantojito.R
import edu.unicauca.aplimovil.dulceantojito.navigation.AppScreens

//creamos una clase y creamos una lista de productos
data class Product(val id: Int, val name: String, val price: Int, val imageUrl: Int)
//lista productos
val productList = listOf(
    Product(1,"Hamburguesa", 45800, R.drawable.product1),
    Product(2,"Perro Caliente", 24000, R.drawable.product2),
    Product(3, "Pizza", 36700, R.drawable.product3),
)


// se asigna o ejecuta la navegacion y el cuerpo de la pantalla

@Composable
fun listadoProducto(navController: NavController){
    Scaffold{
        ProductList(navController)
    }
}

//cuerpo de la pantalla
@Composable
fun ProductList(navController: NavController) {
    //columna
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //imagen de nombre del negocio
        Image(
            painter = painterResource(R.drawable.nombre), // Reemplaza "my_image" con el nombre de tu imagen en el directorio "res/drawable"
            contentDescription = "Imagen1",
            //modifier = Modifier.fillMaxSize()
        )
        //imagen del logo
        Image(
            painter = painterResource(R.drawable.logo), // Reemplaza "my_image" con el nombre de tu imagen en el directorio "res/drawable"
            contentDescription = "Imagen2",
            modifier = Modifier.size(100.dp) //tamaño
            //modifier = Modifier.fillMaxSize()
        )
        //espacion en pantalla
        Spacer(modifier = Modifier.height(16.dp))

        //ejecuta y crea el listado de la lista producto
        //va corriendo de uno en uno
        LazyColumn(modifier = Modifier .padding(16.dp)) {
            items(productList) { product ->
                ProductItem(product, navController)

            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //botones de login y registro
        Button(onClick = {
        /* Lógica de navegacion */
            //ruta
            navController.navigate(route = AppScreens.resgistro.route)
        }) {
            Text("Registrarse")
        }
        Button(onClick = {
            /* Lógica de navegacion */
            navController.navigate(route = AppScreens.login.route)
        }) {
            Text("Login")

        }
    }
}

//funcion que imprime el producto
@Composable
fun ProductItem(product : Product, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            //imprime la imagen de la lista
            Image(
                painter = painterResource(id = product.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                //llamamos al nombre
                Text(text = product.name, style = MaterialTheme.typography.h6)
                //llamamos al precio
                Text(text = "$${product.price}", style = MaterialTheme.typography.body2)

                Button(onClick = {
                    //ruta para navegar a la descripcion del prodycto
                    navController.navigate(route = AppScreens.DescripcionProducto.route)
                }) {
                    Text("comprar")
                }

            }
        }
    }
}


