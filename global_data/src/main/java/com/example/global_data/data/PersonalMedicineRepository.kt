package com.example.global_data.data

class PersonalMedicineRepository {
    var medicineWholeData: ArrayList<MedicineItemWholeInfo> = arrayListOf()

    init {
        medicineWholeData.add(MedicineItemWholeInfo("Гексоген", "Пшик", "", "", "11/08/2021", "9/08/2021", "",
        "150мл.", 20, false, "", ""))
    }
}