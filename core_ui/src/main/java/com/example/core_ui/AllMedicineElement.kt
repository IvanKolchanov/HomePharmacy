package com.example.core_ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.core_ui.databinding.AllMedicineElementBinding

class AllMedicineElement
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    private var _binding: AllMedicineElementBinding? = null


    init {
        val view = View.inflate(context, R.layout.all_medicine_element, this)
        _binding = AllMedicineElementBinding.bind(view)
    }
}