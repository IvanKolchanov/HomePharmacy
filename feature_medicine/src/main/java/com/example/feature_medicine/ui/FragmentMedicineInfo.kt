package com.example.feature_medicine.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.feature_medicine.R
import com.example.feature_medicine.data.MedicineRepository
import com.example.feature_medicine.databinding.FragmentMedicineInfoBinding
import com.example.global_data.data.MedicineItemWholeInfo
import com.google.android.material.bottomsheet.BottomSheetBehavior
import java.text.SimpleDateFormat
import java.util.*


class FragmentMedicineInfo : Fragment() {

    private val itemInfo: MedicineItemWholeInfo = MedicineItemWholeInfo()
    private val medicineRepository = MedicineRepository()
    private var isMedicineCreated: Boolean = false
    private lateinit var _binding: FragmentMedicineInfoBinding
    private var currentRadioGroup: Int = 0

    private lateinit var bottomSheetBehavior : BottomSheetBehavior<View>


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_medicine_info, container, false)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMedicineInfoBinding.bind(view).apply {
            bottomSheetBehavior = BottomSheetBehavior.from(medicineRadioButtonListBottomSheet)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            bottomSheetBehavior.skipCollapsed
            bottomSheetBehavior.isFitToContents = false
            val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when (newState) {
                        BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                        }
                    }
                }
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                }
            }
            bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)

            medicineRadioButtonListBackButton.setOnClickListener{
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            }

            medicineInfoCustomToolbar.setOnClickListenerBackButton {
                Navigation.findNavController(view).popBackStack()
            }

            medicineInfoCustomToolbar.setOnClickListenerRightButton {
                Navigation.findNavController(view).popBackStack()
            }

            imageButtonFreshUntil.setOnClickListener {
                showingDatePickerDialog(EXPIRATION_DATE_ENTERING_ID)
            }

            zTextViewFreshUntil.setOnClickListener {
                showingDatePickerDialog(EXPIRATION_DATE_ENTERING_ID)
            }

            imageButtonFinishingDate.setOnClickListener {
                showingDatePickerDialog(FINISHING_DATE_ENTERING_ID)
            }

            zTextViewFinishingDate.setOnClickListener {
                showingDatePickerDialog(FINISHING_DATE_ENTERING_ID)
            }

            imageButtonAmountPerUnit.setOnClickListener {
                zEditTextAmountPerUnit.requestFocus()
            }

            imageButtonMaxAmount.setOnClickListener {
                zEditTextMaxAmount.requestFocus()
            }

            imageButtonCurrentAmount.setOnClickListener {
                zEditTextCurrentAmount.requestFocus()
            }

            imageButtonCategory.setOnClickListener {
                medicineRadioButtonListTitle.text = getString(R.string.categories_title)
                fullingARadioGroup(medicineRepository.medicineCategoriesList, medicineRadioButtonListRadioGroup, CATEGORIES_RADIO_GROUP_ID)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                medicineRadioButtonListRadioGroup.setOnCheckedChangeListener { group, checkedId ->
                    val chosenRadioButton = group.findViewById<RadioButton>(checkedId)
                    zTextViewCategory.text = chosenRadioButton?.text
                    itemInfo.medicineCategory = chosenRadioButton?.text.toString()
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                }
            }

            imageButtonType.setOnClickListener {
                medicineRadioButtonListTitle.text = getString(R.string.type_title_text)
                fullingARadioGroup(medicineRepository.medicineTypeList, medicineRadioButtonListRadioGroup, TYPE_RADIO_GROUP_ID)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                medicineRadioButtonListRadioGroup.setOnCheckedChangeListener { group, checkedId ->
                    val chosenRadioButton = group.findViewById<RadioButton>(checkedId)
                    zTextViewType.text = chosenRadioButton?.text
                    itemInfo.medicineType = chosenRadioButton?.text.toString()
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                }
            }

            imageButtonOftenness.setOnClickListener {
                medicineRadioButtonListTitle.text = getString(R.string.oftenness_of_taking_title_text)
                fullingARadioGroup(medicineRepository.oftennessList, medicineRadioButtonListRadioGroup, OFTENNESS_RADIO_GROUP_ID)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                medicineRadioButtonListRadioGroup.setOnCheckedChangeListener { group, checkedId ->
                    val chosenRadioButton = group.findViewById<RadioButton>(checkedId)
                    zTextViewTakingOftenness.text = chosenRadioButton?.text
                    itemInfo.medicineTakingOftenness = chosenRadioButton?.text.toString()
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                }
            }
        }

        val dateFormat = SimpleDateFormat("dd/MM/yy")
        itemInfo.startedTakingDate = dateFormat.format(Date())
    }

    private fun fullingARadioGroup(strings: ArrayList<String>, radioGroup: RadioGroup, radioGroupId: Int) {
        if (radioGroupId != currentRadioGroup) {
            currentRadioGroup = radioGroupId
            var stringToMark = ""
            when (radioGroupId) {
                TYPE_RADIO_GROUP_ID -> {
                    stringToMark = itemInfo.medicineType
                }
                CATEGORIES_RADIO_GROUP_ID -> {
                    stringToMark = itemInfo.medicineCategory
                }
                OFTENNESS_RADIO_GROUP_ID -> {
                    stringToMark = itemInfo.medicineTakingOftenness
                }
            }
            clearRadioGroup(radioGroup)
            for (listItem in strings) {
                val newRadioButton = RadioButton(context)
                newRadioButton.textSize = 18F
                val params = RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                params.setMargins(16, 16, 16, 16)
                newRadioButton.layoutParams = params
                if (listItem == stringToMark) {
                    newRadioButton.isChecked = true
                }
                newRadioButton.text = listItem
                radioGroup.addView(newRadioButton)
            }
        }
    }

    private fun showingDatePickerDialog(enteringDate: Int) {
        val datePickerDialog = context?.let { DatePickerDialog(it) }
        datePickerDialog?.setOnDateSetListener { _, year, month, dayOfMonth ->
            when (enteringDate) {
                FINISHING_DATE_ENTERING_ID -> {
                    itemInfo.finishingTakingDate = "$dayOfMonth/$month/$year"
                    _binding.zTextViewFinishingDate.text = itemInfo.finishingTakingDate
                }
                EXPIRATION_DATE_ENTERING_ID -> {
                    itemInfo.expirationDate = "$dayOfMonth/$month/$year"
                    _binding.zTextViewFreshUntil.text = itemInfo.expirationDate
                }
            }
        }
        datePickerDialog?.show()
    }

    private fun clearRadioGroup(radioGroup: RadioGroup) {
        for (i in radioGroup.childCount - 1 downTo 0) {
            val o = radioGroup.getChildAt(i)
            if (o is RadioButton) {
                radioGroup.removeViewAt(i)
            }
        }
    }

    companion object {
        const val FINISHING_DATE_ENTERING_ID = 1
        const val EXPIRATION_DATE_ENTERING_ID = 2
        const val TYPE_RADIO_GROUP_ID = 11
        const val CATEGORIES_RADIO_GROUP_ID = 12
        const val OFTENNESS_RADIO_GROUP_ID = 13
    }
}