package com.example.feature_medicine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature_medicine.R
import com.example.feature_medicine.databinding.FragmentDrugsBinding


class DrugsFragment : Fragment() {

    lateinit var binding: FragmentDrugsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_drugs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDrugsBinding.bind(view).apply {

            medicineToolbar.setOnClickListener {  }
            val medicineWarningElement = MedicineWarningElement(ResourcesCompat.getDrawable(context?.resources!!, R.drawable.ic_example_capsules_warning, null)!!, "Истёк срок годности", "Лоперамид, ост. 3 капсулы")
            notificationsRecycleView.adapter = MedicineWarningElementAdapter(arrayListOf(medicineWarningElement, medicineWarningElement, medicineWarningElement, medicineWarningElement, medicineWarningElement))
            notificationsRecycleView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL).apply {
                setDrawable(ResourcesCompat.getDrawable(context?.resources!!, R.drawable.recycle_view_horizontal_separation_drawable, null)!!)
            })
            val categoriesList: ArrayList<String> = arrayListOf("Aллергия", "Covid-19", "Диабет", "Простуда и грипп", "Витамины и БАД", "Гастрит", "Зрение", "Изжога", "Избыточный вес", "Отит", "Насморк", "Проблемы с пищеварением и кишечником", "Кожные заболевания", "Личная гигиена", "Дыхательная система", "Сердечно-сосудистые", "Другое")
            categoriesRecycleView.adapter = MedicineCategoriesAdapter(categoriesList)
            categoriesRecycleView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL).apply {
                setDrawable(ResourcesCompat.getDrawable(context?.resources!!, R.drawable.recycle_view_vertical_separation_drawable, null)!!)
            })
        }
    }


}