package pe.upeu.navigationjpc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pe.upeu.navigationjpc.ui.presentation.screens.BarcodeScanningScreen
import pe.upeu.navigationjpc.ui.presentation.screens.CalcScreen
import pe.upeu.navigationjpc.ui.presentation.screens.HomeScreen
import pe.upeu.navigationjpc.ui.presentation.screens.ProfileScreen
import pe.upeu.navigationjpc.ui.presentation.screens.SettingsScreen
//Rutas
@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
        composable("calc") { CalcScreen {} }
        composable("barcode") { BarcodeScanningScreen(navController) }
    }
}