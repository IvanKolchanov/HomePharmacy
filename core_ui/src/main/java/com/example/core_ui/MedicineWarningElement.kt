package com.example.core_ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.core_ui.databinding.MedicineWarningElementBinding

class MedicineWarningElement
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    private var _binding: MedicineWarningElementBinding? = null

    init {
        val view = View.inflate(context, R.layout.medicine_warning_element, this)
        _binding = MedicineWarningElementBinding.bind(view)
        this.background = ColorDrawable(Color.TRANSPARENT)
    }
}