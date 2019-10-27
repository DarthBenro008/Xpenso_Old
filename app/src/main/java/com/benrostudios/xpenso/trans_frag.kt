package com.benrostudios.xpenso

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx

class trans_frag: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragview = inflater.inflate(R.layout.transactions ,null)

        return fragview
    }
}