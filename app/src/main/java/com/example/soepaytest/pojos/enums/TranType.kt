package com.example.soepaytest.pojos.enums

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class TranType: Parcelable {
    SALE,
    VOID,
    REFUND,
    AUTH,
    AUTH_COMPLETE,
}