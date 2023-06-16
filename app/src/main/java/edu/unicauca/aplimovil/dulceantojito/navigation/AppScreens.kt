package edu.unicauca.aplimovil.dulceantojito.navigation

//es la clase que permite conocer todas las pantallas (hacer conocer las pantallas)
sealed class AppScreens(val route: String){
    object listadoProducto: AppScreens("mostrar_s")
    object login: AppScreens("login_s")
    object resgistro: AppScreens("registro_s")
    object DescripcionProducto: AppScreens("descP_s")
    object Canasta: AppScreens("canas_s")

}

