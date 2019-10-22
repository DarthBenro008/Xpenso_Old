package com.benrostudios.xpenso

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class spend_frag : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val Fragview = inflater.inflate(R.layout.xpenditures ,null)

        return Fragview
    }
}
