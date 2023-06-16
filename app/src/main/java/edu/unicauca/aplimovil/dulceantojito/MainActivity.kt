package edu.unicauca.aplimovil.dulceantojito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.unicauca.aplimovil.dulceantojito.navigation.AppNavigation
import edu.unicauca.aplimovil.dulceantojito.ui.theme.dulceantojitoTheme

//clase main donde se empiza a ejecutar todo
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            dulceantojitoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

//funciuo compinible de kotlin y preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    dulceantojitoTheme {
        AppNavigation()
    }
}

