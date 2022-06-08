package afc.bpc.transport.bpcbillet.soepay.pojos.enums

enum class EntryMode {
    MANUAL,
    MAGSTRIPE,
    FALLBACK,
    CONTACTLESS,
    CHIP,
    QR_SCAN,
    QR_PRESENT,
    CASH,
}