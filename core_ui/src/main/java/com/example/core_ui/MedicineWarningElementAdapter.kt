package com.example.core_ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedicineWarningElementAdapter (private val medicineWarningElements: ArrayList<MedicineWarningElement>) : RecyclerView.Adapter<MedicineWarningElementAdapter.ViewHolder>() {
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var medicineFormImage: ImageView? = null
        var warningTypeText: TextView? = null
        var warningReasonText: TextView? = null
        var allMedicineNumber: TextView? = null

        fun initialize() {
            if (itemViewType == 0) {
                medicineFormImage = view.findViewById(R.id.medicine_form_icon)
                warningTypeText = view.findViewById(R.id.medicine_warning_type)
                warningReasonText = view.findViewById(R.id.medicine_warning_cause)
            }else {
                allMedicineNumber = view.findViewById(R.id.all_medicine_number)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = if (viewType == 0) {
            LayoutInflater.from(parent.context).inflate(R.layout.medicine_warning_element, parent, false)
        }else {
            LayoutInflater.from(parent.context).inflate(R.layout.all_medicine_element, parent, false)
        }
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = medicineWarningElements.size

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            1
        }else {
            super.getItemViewType(position)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initialize()
        if (holder.itemViewType == 0) {
            if (position > 0) {
                val currentWarningElement: MedicineWarningElement = medicineWarningElements[position]
                holder.medicineFormImage?.setImageDrawable(currentWarningElement.medicineFormImage)
                holder.warningTypeText?.text = currentWarningElement.warningTypeText
                holder.warningReasonText?.text = currentWarningElement.warningReasonText
            }
        }else {
            holder.allMedicineNumber?.text = 13.toString();
        }
    }

}