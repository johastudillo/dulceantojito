package edu.unicauca.aplimovil.dulceantojito.screens

import android.annotation.SuppressLint
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.aplimovil.dulceantojito.R

//funcion que muestra la pantalla
@Composable
fun login(navController: NavController){
    Scaffold(topBar = {
        //boton volver
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back", modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Volver")
            //---
        }
        // no es un error como tal solo es advertencia
    }){
        LoginScreen(navController) //llamamos al cuerpo
    }
}

//funcion del cuerpo de la pantalla
@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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
        Text(text = "Login", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))

        //campo para ingresar correo
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        //campo para ingresar contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            //la contraseña no sea visible
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(text = "Log in")
        }
    }
}

//fun performLogin(email: String, password: String) {
    // Aquí puedes implementar la lógica de inicio de sesión
    // Por ejemplo, puedes llamar a una API de autenticación o verificar los datos en una base de datos
//}


