package com.example.core_ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.core_ui.databinding.MyCustomToolbarBinding

class MyCustomToolbar
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : Toolbar(context, attrs, defStyleAttr) {


    private var _binding: MyCustomToolbarBinding? = null

    init {
        val view = View.inflate(context, R.layout.my_custom_toolbar, this)
        _binding = MyCustomToolbarBinding.bind(view)
        applyAttributes(attrs)
    }

    private fun applyAttributes(attrs: AttributeSet?) {
        attrs?.let {
            val attributes = context.obtainStyledAttributes(it, R.styleable.MyCustomToolbar, 0, 0)
            with(attributes) {
                try {
                    val title = getString(R.styleable.MyCustomToolbar_toolbar_title)
                    _binding?.toolbarTitle?.text = title

                    val button = getString(R.styleable.MyCustomToolbar_button_text)
                    _binding?.button?.text = button

                } finally {
                    recycle()
                }
            }
        }
    }


    fun setOnClickListener(click: (() -> Unit)? = null) {

        _binding?.button?.setOnClickListener {
            click?.invoke()
        }
    }

}




