package com.example.core_ui

import android.graphics.drawable.Drawable

class MedicineWarningElement
constructor(medicineFormImage: Drawable, warningTypeText: String, warningReasonText: String){
    var medicineFormImage: Drawable? = null
    var warningTypeText: String? = null
    var warningReasonText: String? = null

    init {
        this.medicineFormImage = medicineFormImage
        this.warningTypeText = warningTypeText
        this.warningReasonText = warningReasonText
    }
}