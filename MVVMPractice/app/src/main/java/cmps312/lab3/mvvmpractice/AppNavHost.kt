package cmps312.lab3.mvvmpractice

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cmps312.lab3.mvvmpractice.view.Add
import cmps312.lab3.mvvmpractice.view.Home

@Composable
fun AppNavHost(navHostController: NavHostController){

    //StartDestination-> Home (screen class )
NavHost(navController = navHostController, startDestination = Screen.Home.route){

    //define composable route for each screen

composable(route = Screen.Home.route){
    //the navigation(navhost) will be called on the onAdd{floating}
    Home(onAdd = {navHostController.navigate(Screen.Add.route)})
}
composable(route=Screen.Add.route){
    Add(onAddStudent = {navHostController.navigate(Screen.Home.route)})
}
}
}