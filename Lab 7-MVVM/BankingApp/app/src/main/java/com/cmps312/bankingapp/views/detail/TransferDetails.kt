package com.cmps312.bankingapp.views.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cmps312.bankingapp.Screen
import com.cmps312.bankingapp.views.BankingViewModel

//Todo add the navigation
@Composable
fun TransferDetails(
    navHostController: NavHostController,
    bankingViewModel: BankingViewModel,
) {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxSize(), elevation = 16.dp) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConfirmation() {
    //TransferDetails(navHostController = NavHostController, bankingViewModel = BankingViewModel )
}