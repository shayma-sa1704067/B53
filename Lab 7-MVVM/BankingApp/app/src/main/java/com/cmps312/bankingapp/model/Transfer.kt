package com.cmps312.bankingapp.model

import kotlinx.serialization.Serializable
import java.security.SecureRandom
@Serializable
class Transfer (

    var beneficiaryName : String? ="",
    var beneficiaryAccountNo : String?= "",
    val fromAccountNo :String?= "",
    val amount: Double?=0.0,
    val transferId :Int?= 0

    )