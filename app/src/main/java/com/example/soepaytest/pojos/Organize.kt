package afc.bpc.transport.bpcbillet.soepay.pojos

import java.io.Serializable

data class Organize(
    /**
    SoePay SoftPOS API Integration Document 15
     * Organization name
     */
    val name: String? = null,
    /**
     * Organization address
     */
    val address: String? = null,
) : Serializable