package cmps312.bankingapp.viewmodel

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cmps312.bankingapp.api.BankService
import cmps312.bankingapp.model.Account
import cmps312.bankingapp.model.Beneficiary
import cmps312.bankingapp.model.Transfer
import kotlinx.coroutines.async
import kotlinx.coroutines.launch




