package afc.bpc.transport.bpcbillet.soepay.pojos
import java.io.Serializable

data class CardData(
    val tc: String? = null,
    val approvalCode: String? = null,
    val appName: String? = null,
    val aid: String? = null,
    val mid: String? = null,
    val tid: String? = null,
    val tvr: String? = null,
    val tsi: String? = null,
    val atc: String? = null,
) : Serializable