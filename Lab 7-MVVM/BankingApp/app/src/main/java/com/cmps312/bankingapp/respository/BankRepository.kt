package com.cmps312.bankingapp.respository

import android.content.Context
import com.cmps312.bankingapp.model.Account
import com.cmps312.bankingapp.model.Beneficiary
import com.cmps312.bankingapp.model.Transfer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

//in the repository we need to load the JSON file into the classes that we have created
class BankRepository(private val context: Context){

    //1-Create function that reads the data

    private fun readData(filename:String)=
        context.assets.open(filename).bufferedReader().use { it.readText() }

    //get the list of transfer
    //first get the transfers
    //put the data from the transfer.json
    //<list ->> becasuse if you open the json file of the transfer you would see the data as a list

    fun  getTransfer()=
        Json.decodeFromString<List<Transfer>>(readData("transfers.json"))

    //create a func for the beneficary
    fun getBeneficiaries()=
        Json.decodeFromString<List<Beneficiary>>(readData("beneficiaries.json"))


    //function for account
    fun getAccounts()=
        Json.decodeFromString<List<Account>>(readData("accounts.json"))
}