package com.example.homepharmacy.navigationfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.core_ui.CalendarCustomToolbar
import com.example.core_ui.MedicineCustomToolbar
import com.example.homepharmacy.R

class CalendarFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: CalendarCustomToolbar = view.findViewById(R.id.calendar_toolbar)
        toolbar.setOnClickListenerAddButton {}
        toolbar.setOnClickListenerSearchButton {}
    }
}