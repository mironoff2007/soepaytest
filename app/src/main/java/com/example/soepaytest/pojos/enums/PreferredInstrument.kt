package com.example.soepaytest.pojos.enums

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class PreferredInstrument: Parcelable {
    CASH,
    CARD,
    QR
}