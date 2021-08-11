package com.example.feature_medicine.data

import com.example.feature_medicine.R

class MedicineRepository {

    private val medicineWarningElement = MedicineWarningElement(R.drawable.ic_example_capsules_warning, "Истёк срок годности", "Лоперамид, ост. 3 капсулы")
    val asd = arrayListOf(medicineWarningElement, medicineWarningElement, medicineWarningElement, medicineWarningElement, medicineWarningElement)

    val medicineCategoriesList = arrayListOf("Aллергия", "Covid-19", "Диабет", "Простуда и грипп", "Витамины и БАД", "Гастрит", "Зрение", "Изжога", "Избыточный вес", "Отит", "Насморк", "Проблемы с пищеварением и кишечником", "Кожные заболевания", "Личная гигиена", "Дыхательная система", "Сердечно-сосудистые", "Другое")
}