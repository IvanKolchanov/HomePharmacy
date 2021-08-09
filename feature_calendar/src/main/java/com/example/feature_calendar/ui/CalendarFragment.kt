package com.example.feature_calendar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import com.example.core_ui.CalendarCustomToolbar
import com.example.feature_calendar.R
import com.example.feature_calendar.databinding.FragmentCalendarBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class CalendarFragment : Fragment() {

    private lateinit var binding: FragmentCalendarBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCalendarBinding.bind(view).apply {
            calendarToolbar.setOnClickListenerAddButton {}
            calendarToolbar.setOnClickListenerSearchButton {}

            //medicineNotificationsRecycleView.adapter =
            var bottomSheetBehavior = BottomSheetBehavior.from(medicineNotificationsBottomSheet)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            bottomSheetBehavior.isHideable = false
        }
    }
}