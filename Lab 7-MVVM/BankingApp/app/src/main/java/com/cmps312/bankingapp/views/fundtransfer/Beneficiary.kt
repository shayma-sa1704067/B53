package com.cmps312.bankingapp.views.beneficiary

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cmps312.bankingapp.Screen
import com.cmps312.bankingapp.model.Beneficiary
import com.cmps312.bankingapp.views.BankingViewModel


@Composable
fun Beneficiary(navHostController: NavHostController, bankingViewModel: BankingViewModel) {
    LazyColumn {
            //display the list of all beneficiaries [the one in the json file ]
      items(bankingViewModel.beneficiaries) { beneficiary ->  //ben..-> we create an instance of this lambda
          //for each item [beneficiary -> ] do display beneficiary card
          BeneficiaryCard(beneficiary,onSelectedBeneficiary = {
              bankingViewModel.apply {
                 //when i select on any of the beneficiary card that consist of [name , account no.] it will do 2 things :

                  //1- it will navigate us to the confirmation screen
                  // 2-do the new transfer [add 2 details {benficaaccount , benificamount }]
                  newTransfer.beneficiaryAccountNo = beneficiary.accountNo
                  newTransfer.beneficiaryName= beneficiary.name
              }
              navHostController.navigate(Screen.Confirmation.route)
          })


      }
    }
}

@Composable
fun BeneficiaryCard(beneficiary: Beneficiary, onSelectedBeneficiary: () -> Unit) {
    Card(elevation = 10.dp,
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(10.dp)
            .clickable { onSelectedBeneficiary() }) {
        Row(modifier = Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Screen.Beneficiary.icon, contentDescription = "Person Image")
            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Name : ${beneficiary.name}")
                Text(text = "AccountNo : ${beneficiary.accountNo}")
            }
        }
    }
}

