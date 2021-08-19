package com.example.global_data.data

data class MedicineItemWholeInfo (
        var medicineName: String,
        var medicineType: String,
        var medicineCategory: String,
        var linkToInstruction: String,
        //dd/MM/yy
        var startedTakingDate: String,
        var expirationDate: String,
        var finishingTakingDate: String,
        var medicineMaxAmount: String,
        var medicineCurrentAmount: Int,
        var isAmountCountable: Boolean,
        var medicineTakingOftenness: String,
        var notes: String
){
    constructor() : this("", "", "", "", "",
            "", "", "", 0, false, "", "")
}