package com.example.feature_medicine.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.feature_medicine.data.MedicineRepository
import com.example.feature_medicine.data.MedicineWarningElement

class MedicineViewModel (application: Application): AndroidViewModel(application) {

    private var medicineRepository: MedicineRepository = MedicineRepository()

    private val _medicines: MutableLiveData<List<MedicineWarningElement>> = MutableLiveData(medicineRepository.asd)
    private val _categories: MutableLiveData<ArrayList<String>> = MutableLiveData(medicineRepository.medicineCategoriesList)

    val medicines: LiveData<List<MedicineWarningElement>> get() = _medicines
    val categories: LiveData<ArrayList<String>> get() = _categories

    fun clear() {
        _medicines.postValue(arrayListOf())
    }
}