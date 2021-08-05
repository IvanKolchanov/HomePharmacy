package com.example.homepharmacy.navigationfragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.MedicineCustomToolbar
import com.example.core_ui.MedicineWarningElement
import com.example.core_ui.MedicineWarningElementAdapter
import com.example.homepharmacy.R

class DrugsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_drugs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: MedicineCustomToolbar = view.findViewById(R.id.medicine_toolbar)
        toolbar.setOnClickListenerAddButton {}
        val recyclerView: RecyclerView = view.findViewById(R.id.notifications_recycle_view)
        val medicineWarningElement = MedicineWarningElement(ResourcesCompat.getDrawable(context?.resources!!, R.drawable.ic_example_capsules_warning, null)!!, "Истёк срок годности", "Лоперамид, ост. 3 капсулы")
        recyclerView.adapter = MedicineWarningElementAdapter(arrayListOf(medicineWarningElement, medicineWarningElement, medicineWarningElement, medicineWarningElement, medicineWarningElement, medicineWarningElement))
        //recyclerView.adapter = medicineWarningElements?.let { MedicineWarningElementAdapter(it) }
    }
}