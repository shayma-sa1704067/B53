package com.cmps312.bankingapp.views.fundtransfer


import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cmps312.bankingapp.Screen
import com.cmps312.bankingapp.model.Transfer
import com.cmps312.bankingapp.views.BankingViewModel

//Todo : add the call back
@Composable
fun FundTransfer(navHostController: NavHostController, bankViewModel: BankingViewModel) {

    //a the home screen we have -> select account[drop down ] , amount
    //these are changeable / we add more in progress so itsa mutablestate
    var fromAccount by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    var expandable by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    var selectedBeneficiary by remember {
        mutableStateOf("Select Your Account")
    }

    //Todo getView model instance

    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxSize(), elevation = 16.dp) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,

            ) {

            Text(text = "Fund Transfer",
                Modifier
                    .align(
                        Alignment.CenterHorizontally)
                    .padding(16.dp), fontWeight = FontWeight.Bold)
            Divider()
            /*
                Drop Down
             */
            //first textfiels it has/composed of row of  ->
            //1-  Outlined text filed
            //2- drop down
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { expandable = !expandable }) {
                OutlinedTextField(
                    value = selectedBeneficiary,
                    onValueChange = { },
                    enabled = false, leadingIcon = {
                        Icon(imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Accounts")
                    },
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(16.dp, 0.dp)
                        .fillMaxWidth()
                )
                //its displaing a list of accounts
                DropdownMenu(expanded = expandable, onDismissRequest = { expandable = false }) {
            //we created above an instance of bankViewModel ,so we called it

                    bankViewModel.accounts.forEach { account ->
                        DropdownMenuItem(onClick = {
                            expandable = false
                            selectedBeneficiary = account.toString()
                            fromAccount = account.accountNo //whatever the user select from it take the account.accountNO
                        }) {
                            Text(text = "$account", fontWeight = FontWeight.Bold)
                        }

                    }
                }

            }

            OutlinedTextField(value = amount,
                onValueChange = { amount = it },
                label = { Text(text = "Amount ") },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally)
                    .padding(16.dp)
                    .fillMaxWidth()
            )

    // Button does 2 things
            //2-  also adds sth to the new transfer when we click on fun transfer
            //1- then it navigate me  to the beneficiary screen

            Button(onClick = {
                if (fromAccount != "Select Your Account" &&
                    amount.isNotEmpty()
                ) {
                    //Todo  set the from account details and amount in the newAccount object inside the BankViewModel
                    bankViewModel.apply {
                        newTransfer = Transfer(fromAccountNo = fromAccount, amount = amount.toDouble())
                    }

                    //Todo add the navigation here
                    navHostController.navigate(Screen.Beneficiary.route)

                } else {
                    Toast.makeText(context, "Please provide all the information",
                        Toast.LENGTH_SHORT).show()
                }
            },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally)
                    .padding(16.dp)) {
                Text(text = "Fund Transfer")
            }
        }
    }

}

@Preview
@Composable
fun DisplayFunTransfer() {
    val navHostController = rememberNavController()
    val beneficiaryViewModel: BankingViewModel = viewModel()
    FundTransfer(navHostController, beneficiaryViewModel)
}