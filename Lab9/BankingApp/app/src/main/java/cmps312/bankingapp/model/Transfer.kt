package cmps312.bankingapp.model

import kotlinx.serialization.Serializable
import java.security.SecureRandom

@Serializable
class Transfer(
    var fromAccountNo: String = "",
    var amount: Double = 0.0,
    var beneficiaryName: String = "",
    var beneficiaryAccountNo: String = "",
    var transferId: String = SecureRandom().nextInt(100000).toString(),
    var cid: Int = 10001,
)
