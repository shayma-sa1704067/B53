package com.cmps312.bankingapp.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cmps312.bankingapp.Screen
import com.cmps312.bankingapp.views.beneficiary.Beneficiary
import com.cmps312.bankingapp.views.detail.TransferDetails
import com.cmps312.bankingapp.views.fundtransfer.FundTransfer
import com.cmps312.bankingapp.views.fundtransfer.TransferConfirmation
import com.cmps312.bankingapp.views.home.Home

@Composable
fun MyNavHost(navHostController: NavHostController, bankViewModel: BankingViewModel) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) { Home(navHostController ,bankViewModel) }
        composable(route = Screen.AccountDetail.route) { AccountDetails(navHostController) }
        composable(route = Screen.FundTransfer.route) { FundTransfer(navHostController, bankViewModel) }
        composable(route = Screen.Beneficiary.route) { Beneficiary(navHostController, bankViewModel) }
        composable(route = Screen.Confirmation.route) { TransferConfirmation(navHostController, bankViewModel) }
        composable(route = Screen.TransferDetails.route) { TransferDetails(navHostController, bankViewModel) }
    }
}