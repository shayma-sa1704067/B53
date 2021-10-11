package com.cmps312.bankingapp.views.fundtransfer

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
fun TransferConfirmation(navHostController: NavHostController, bankingViewModel: BankingViewModel) {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxSize(), elevation = 16.dp) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            bankingViewModel.apply {
                Text(text = "From Account Number : ${newTransfer.fromAccountNo}")//we only need the new Transfer so ->$...
                Text(text = "Account Transferred : ${newTransfer.amount}")
                Text(text = "Beneficiary Account Number : ${newTransfer.beneficiaryAccountNo} ")
                Text(text = "Beneficiary Name : ${newTransfer.beneficiaryName}")

                //when i click on the confirm button ->
                // 1-[ navigate]it taking me back to the home screen
                // 2-  add the new transfer that we just create it

                Button(onClick = { bankingViewModel.addTransfer
                navHostController.navigate(Screen.Home.route)

                }) {
                    Text(text = "Confirm")
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConfirmation() {
//    Confirmation(Transfer("12345","Ali","12345",123.7))
}