package com.example.feature_medicine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.MedicineCustomToolbar
import com.example.feature_medicine.R
import com.example.feature_medicine.databinding.FragmentDrugsBinding
import com.example.feature_medicine.domain.MedicineViewModel

class MedicineFragment : Fragment() {

    lateinit var binding: FragmentDrugsBinding
    lateinit var medicineViewModel: MedicineViewModel

    private var medicineToolbar: MedicineCustomToolbar? = null
    private var notificationsRecyclerView: RecyclerView? = null
    private var categoriesRecyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_drugs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //getting viewModel
        medicineViewModel = ViewModelProvider(this).get(MedicineViewModel::class.java)
        //getting binding
        binding = FragmentDrugsBinding.bind(view)
        //initializing views
        medicineToolbar = binding.medicineToolbar
        notificationsRecyclerView = binding.notificationsRecyclerView
        categoriesRecyclerView = binding.categoriesRecyclerView
        //setting medicineToolbar on addButton click listener
        medicineToolbar?.setOnClickListenerAddButton {}
        //setting notificationsRecyclerView adapter
        notificationsRecyclerView?.adapter = MedicineWarningElementAdapter( ).apply {
            onAllMedicineItemClick = { findNavController().navigate(R.id.all_medicine_destination_fragment) }

        }
        //creating an observer that will monitor if medicineWarningElements had changed
        medicineViewModel.medicines.observe (viewLifecycleOwner, { medicinesList ->
            (notificationsRecyclerView?.adapter as MedicineWarningElementAdapter).medicineWarningElements.clear()
            (notificationsRecyclerView?.adapter as MedicineWarningElementAdapter).medicineWarningElements.addAll(medicinesList)
            (notificationsRecyclerView?.adapter as MedicineWarningElementAdapter).notifyDataSetChanged()
        })
        //adding item decoration to notification recycle view
        notificationsRecyclerView?.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL).apply {
            setDrawable(ResourcesCompat.getDrawable(resources, R.drawable.recycle_view_horizontal_separation_drawable, null)!!)
        })
        //setting up categoriesRecyclerView adapter
        categoriesRecyclerView?.adapter = MedicineCategoriesAdapter(medicineViewModel.categories)
        //adding item decoration to categoriesRecyclerView
        categoriesRecyclerView?.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL).apply {
            setDrawable(ResourcesCompat.getDrawable(resources, R.drawable.recycle_view_vertical_separation_drawable, null)!!)
        })
    }
}