package com.cmps312.bankingapp.views

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.cmps312.bankingapp.model.Transfer
import com.cmps312.bankingapp.respository.BankRepository

class BankingViewModel(appContext: Context) : ViewModel() {
 //extends to viewModel
    // create the accounts which the 2nd screen will listen and will hold all the accounts that i have


    //create an object of banking repository
    private val bankRepository = BankRepository(appContext)

    //-------------------------------------//
    //First--------------------------------//
    //1- we need to have a list of the account


//----> lazy is a function that takes a lambda , and  initilaises the accounts
    val accounts by lazy { bankRepository.getAccounts() }


    //-------------------------------------//
    //Second--------------------------------//
    //1- we need to create beneficiaries which holds all the list of beneficiary


    val beneficiaries by lazy { bankRepository.getBeneficiaries() }

    //-------------------------------------//
    //Third--------------------------------//
    //3- when we click on confirm it will add new transfer [use mutable list ]


    //mutable -> because it will not only have the transfers but will add new more in progress

    var transfers : MutableState<List<Transfer>> = mutableStateOf(listOf())

    init{
        //3.1:initialize the transfer ->> what will be inside the transfer is initial  transfers
        //this will have only the list that are in the json file
        transfers.value = bankRepository.getTransfer()

    }

    //3.2: create an add transfer to [when the user complete the transaction and confirm
// a function gets triggered and it adds to transaction that you just created to this transfer


//whatever value we are choosing in the transaction {account - amount }
    var selectedTransfer by mutableStateOf(Transfer())

    //lateinit -> in the first instance of the app , do not initialize the newtransfer ,
    //only initialize it when its getting called {called in the fun addtrasfer}

     lateinit var newTransfer : Transfer
    val addTransfer ={
        transfers.value?.let {
            transfers.value = it +newTransfer
            //will be added to the list
        }
    }
}