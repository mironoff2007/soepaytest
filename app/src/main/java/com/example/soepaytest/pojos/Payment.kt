package afc.bpc.transport.bpcbillet.soepay.pojos

import afc.bpc.transport.bpcbillet.soepay.pojos.enums.PaymentMethod
import java.io.Serializable

data class Payment(
    val payer: String? = null,
    val payerName: String? = null,
    var paymentMethod: PaymentMethod? = null,
    val createTime: String? = null,
    val lastUpdateTime: String? = null,
    val organize: Organize? = null
) : Serializable