package com.example.soepaytest.pojos

import com.example.soepaytest.pojos.enums.PreferredInstrument
import com.example.soepaytest.pojos.enums.TranType
import android.icu.math.BigDecimal
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class TransactionRequest(
    /**
     * Required for SALE, AUTH, REFUND
     */
    val requestAmount: BigDecimal? = null,
    /**
     * Required for all transaction
     */
    val tranType: String,
    /**
     * The default payment instrument (CARD by default)
     */
    val preferredInstrument: PreferredInstrument? = null,
    /**
     * The unique identifier from the POS
     */
    val messageId: String,
    /**
     * Required for VOID, AUTH_COMPLETE
     */
    val tranId: String? = null,
    /**
     * Optional merchant remarks
     */
    val description: String? = null
) : Parcelable