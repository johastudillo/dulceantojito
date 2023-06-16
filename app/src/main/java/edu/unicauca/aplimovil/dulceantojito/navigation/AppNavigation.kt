package edu.unicauca.aplimovil.dulceantojito.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.unicauca.aplimovil.dulceantojito.screens.*

// funcion para navegar
@Composable
fun AppNavigation(){
    //se crea una variable de tipo remenber (se van a conocer y recordar)
    val navController = rememberNavController()

    //conexion entre pantallas
    NavHost(navController = navController, startDestination = AppScreens.listadoProducto.route){
        //crear las rutas pra comunicacion
        composable(route = AppScreens.listadoProducto.route){
            listadoProducto(navController)
        }
        //crear las rutas pra comunicacion
        composable(route = AppScreens.login.route){
            login(navController)
        }
        //crear las rutas pra comunicacion
        composable(route = AppScreens.resgistro.route){
            resgistro(navController)
        }
        //crear las rutas pra comunicacion
        composable(route = AppScreens.DescripcionProducto.route){
            DescripcionProducto(navController)
        }
        //crear las rutas pra comunicacion y valores como parametro
        composable(route = AppScreens.Canasta.route + "/{text}",
        arguments = listOf(navArgument(name = "text") {
            type = NavType.StringType
        })){
            Canasta(navController, it.arguments?.getString("text"))
        }
    }
}