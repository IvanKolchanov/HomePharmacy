package com.example.feature_medicine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.feature_medicine.R
import com.example.feature_medicine.databinding.FragmentAllMedicineBinding


class AllMedicineFragment : Fragment() {

    lateinit var binding: FragmentAllMedicineBinding
    private lateinit var medicineSortingSpinner: Spinner

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_all_medicine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllMedicineBinding.bind(view).apply{

            allMedicineCustomToolbar.setOnClickListenerBackButton{
                Navigation.findNavController(view).popBackStack()
            }

            medicineSortingSpinner = sortingSpinner
        }

        ArrayAdapter.createFromResource(
                requireContext(),
                R.array.sorting_options_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            medicineSortingSpinner.adapter = adapter
        }
    }
}