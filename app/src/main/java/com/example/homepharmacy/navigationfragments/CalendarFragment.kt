package com.example.homepharmacy.navigationfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.core_ui.MedicineCustomToolbar
import com.example.core_ui.MyCustomToolbar
import com.example.homepharmacy.R

class CalendarFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: MyCustomToolbar = view.findViewById(R.id.my_toolbar)
        toolbar.setOnClickListener {
            Toast.makeText(this.context, "Hello Ivan", Toast.LENGTH_SHORT).show()
        }
    }
}