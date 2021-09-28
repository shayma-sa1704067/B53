package com.cmps312.bankingapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cmps312.bankingapp.common.getCurrentRoute
import com.cmps312.bankingapp.ui.theme.BankingAppTheme
import com.cmps312.bankingapp.views.BankingViewModel
import com.cmps312.bankingapp.views.MyNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp(this)
                }
            }
        }
    }
}

@Composable
fun MyApp(context: Context) {
    val navHostController = rememberNavController()
    val bankViewModel = BankingViewModel(context)
    Scaffold(
        topBar = { TopBar(navHostController) },
        bottomBar = { BottomBar(navHostController) }
    ) {
        MyNavHost(navHostController, bankViewModel)
    }
}


@Composable
fun TopBar(navHostController: NavHostController) {
    Column {
        Text(text = "Top Bar")
    }
}

@Composable
fun BottomBar(navHostController: NavHostController) {
    var bottomNavItems = listOf(
        Screen.Home,
        Screen.FundTransfer,
        Screen.AccountDetail
    )
    val currentRoute = getCurrentRoute(navHostController)
    BottomNavigation {
        bottomNavItems.forEach { screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                onClick = { navHostController.navigate(screen.route) },
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
                label = { Text(text = screen.title) },
                alwaysShowLabel = true
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BankingAppTheme {
        MyApp(LocalContext.current)
    }
}