package com.example.feature_medicine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_medicine.R
import com.example.feature_medicine.databinding.FragmentAllMedicineBinding
import com.example.feature_medicine.domain.MedicineViewModel


class AllMedicineFragment : Fragment() {

    private lateinit var binding: FragmentAllMedicineBinding
    private lateinit var medicineViewModel: MedicineViewModel
    private lateinit var medicineSortingSpinner: Spinner
    private lateinit var medicineInfoRecyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_all_medicine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        medicineViewModel = ViewModelProvider(this).get(MedicineViewModel::class.java)
        binding = FragmentAllMedicineBinding.bind(view).apply{
            allMedicineCustomToolbar.setOnClickListenerBackButton{
                Navigation.findNavController(view).popBackStack()
            }
            medicineSortingSpinner = sortingSpinner
            medicineInfoRecyclerView = allMedicineRecycleView
            allMedicineRecycleView.adapter = MedicineInfoItemAdapter()
        }

        ArrayAdapter.createFromResource(
                requireContext(),
                R.array.sorting_options_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            medicineSortingSpinner.adapter = adapter
        }

        medicineSortingSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            private val BY_ALPHABET : Int = 0
            private val BY_EXPIRING_DATE : Int = 1
            private val BY_AMOUNT : Int = 2

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    BY_ALPHABET -> {
                        (medicineInfoRecyclerView.adapter as MedicineInfoItemAdapter).medicineInfoItemsList.sortWith(compareBy { it.medicineName })
                        (medicineInfoRecyclerView.adapter as MedicineInfoItemAdapter).notifyDataSetChanged()
                    }
                    BY_EXPIRING_DATE -> {
                        (medicineInfoRecyclerView.adapter as MedicineInfoItemAdapter).medicineInfoItemsList.sortWith(compareBy { it.medicineExpirationTime })
                        (medicineInfoRecyclerView.adapter as MedicineInfoItemAdapter).notifyDataSetChanged()
                    }
                    BY_AMOUNT -> {
                        (medicineInfoRecyclerView.adapter as MedicineInfoItemAdapter).medicineInfoItemsList.sortWith(compareBy { it.medicineAmountNumber })
                        (medicineInfoRecyclerView.adapter as MedicineInfoItemAdapter).notifyDataSetChanged()
                    }
                }
            }
        }


        medicineViewModel.medicineInfoItemsList.observe(viewLifecycleOwner, { medicineInfoItemsList ->
            (medicineInfoRecyclerView.adapter as MedicineInfoItemAdapter).medicineInfoItemsList.clear()
            (medicineInfoRecyclerView.adapter as MedicineInfoItemAdapter).medicineInfoItemsList.addAll(medicineInfoItemsList)
            (medicineInfoRecyclerView.adapter as MedicineInfoItemAdapter).notifyDataSetChanged()
        })

        medicineInfoRecyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL).apply {
            setDrawable(ResourcesCompat.getDrawable(resources, R.drawable.recycler_view_vertical_grey_separation_line, null)!!)
        })
    }
}