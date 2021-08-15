package com.example.feature_medicine.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feature_medicine.R
import com.example.feature_medicine.databinding.FragmentMedicineInfoBinding
import androidx.navigation.fragment.findNavController

class FragmentMedicineInfo : Fragment() {

    private var isMedicineCreated : Boolean = false
    private lateinit var _binding: FragmentMedicineInfoBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_medicine_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMedicineInfoBinding.bind(view).apply {
            medicineInfoCustomToolbar.setOnClickListenerBackButton {
                findNavController().popBackStack()
            }

            medicineInfoCustomToolbar.setOnClickListenerRightButton{
                findNavController().popBackStack()
            }
        }
    }
}