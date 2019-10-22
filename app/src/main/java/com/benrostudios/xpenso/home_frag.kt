package com.benrostudios.xpenso

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.home.*

class home_frag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragview = inflater.inflate(R.layout.home, null)


        return fragview
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fab1.setOnClickListener{
            val intent = Intent(context, newadder_activity::class.java)
            startActivity(intent)

        }
    }

}