package com.benrostudios.xpenso

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import java.text.SimpleDateFormat
import java.util.*

class home_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragview = inflater.inflate(R.layout.home, null)

        val sdf = SimpleDateFormat("MMM yyy", resources.configuration.locales[0])
        val currentDate = sdf.format(Date())

        val monthTextView = fragview.findViewById<TextView>(R.id.textview_month_display)
        monthTextView.setText(currentDate)

        val ieCardView = fragview.findViewById<CardView>(R.id.cardview_income_expenses)
        ieCardView.setBackgroundResource(R.drawable.backdrop_ie)

        val expensesCardView = fragview.findViewById<CardView>(R.id.cardview_expenses)
        expensesCardView.setBackgroundResource(R.drawable.backdrop_e)

        val circularProgress = fragview.findViewById<CircularProgressIndicator>(R.id.progress_circular_expenses_percent)

        //TODO: Get income and expenses and store in the respective fields
        val income = 15000.0
        val expenses = 8500.0
        val balance = income - expenses

        circularProgress.setProgress( balance/income*100, 100.0)



        return fragview
    }
}