package afc.bpc.transport.bpcbillet.soepay.pojos

import afc.bpc.transport.bpcbillet.soepay.pojos.enums.EntryMode
import afc.bpc.transport.bpcbillet.soepay.pojos.enums.TranStatus
import com.example.soepaytest.pojos.enums.TranType
import android.icu.math.BigDecimal
import java.io.Serializable

data class TransactionModel(
    /**
     * Amounts
     */
    val totalAmount: BigDecimal? = null,
    /**
     * transaction batch number
     */
    val batch: Int? = null,
    /**
     * sequential transaction trace from Spectra Gateway
     */
    val trace: Long? = null,
    /**
     * unique identifier transaction ID from Spectra Gateway
     */
    val tranId: String? = null,
    /**
     * RRN from payment host
     */
    val processorReference: String? = null,
    /**
     * identifier from the POS
     */
    val messageId: String? = null,
    /**
     * Eligible for void
     */
    val cancelable: Boolean? = null,
    /**
     * Eligible for auth complete
     */
    val capturable: Boolean? = null,
    /**
     * Eligible for refund
     */
    val refundable: Boolean? = null,
    /**
     * Credential
     */
    val createByName: String? = null,
    val createTime: String? = null,
    val lastUpdateTime: String? = null,
    /**
     * Payment details
     */
    val payment: Payment? = null,
    /**
    SoePay SoftPOS API Integration Document 14
     * exist if doing card transaction
     */
    val cardData: CardData? = null,
    /**
     * transaction details
     */
    val tranStatus: TranStatus? = null,
    val tranType: TranType? = null,
    val entryMode: EntryMode? = null,
    val errorCode: Int? = null,
    val ip: String? = null,
    /**
     * Merchant reference (eg. invoice number)
     */
    val description: String? = null,
) : Serializable
