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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.aplimovil.dulceantojito.R
//funcion que muestra la pantalla
@Composable
fun resgistro(navController: NavController){
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
        RegistrationScreen(navController)
    }
}

//funcion del cuerpo de la pantalla
@Composable
fun RegistrationScreen(navController: NavController) {
    var name by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var Telefono by remember { mutableStateOf(TextFieldValue()) }
    var Direccion by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //imagen logo
                Image(
                    painter = painterResource(R.drawable.logo), // Reemplaza "my_image" con el nombre de tu imagen en el directorio "res/drawable"
                    contentDescription = "Imagen2",
                    modifier = Modifier.size(100.dp)
                    //modifier = Modifier.fillMaxSize()
                )
                //texto registro
                Text(text = "Registro", style = MaterialTheme.typography.h4)
                Spacer(modifier = Modifier.height(16.dp))

                //campo de texto pra ingresar
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nombre") }
                )
                //campo de texto pra ingresar
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Correo electrónico") }
                )
                //campo de texto pra ingresar
                OutlinedTextField(
                    value = Telefono,
                    onValueChange = { Telefono = it },
                    label = { Text("Telefono") }
                )
                //campo de texto pra ingresar
                OutlinedTextField(
                    value = Direccion,
                    onValueChange = { Direccion = it },
                    label = { Text("Direccion") }
                )

                //campo de texto pra ingresar
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation()
                )
                Button(onClick = { /* Lógica de registro */ }) {
                    Text("Registrarse")
                }
        }
}

