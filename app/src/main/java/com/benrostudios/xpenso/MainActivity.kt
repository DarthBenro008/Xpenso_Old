package com.benrostudios.xpenso

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() ,  BottomNavigationView.OnNavigationItemSelectedListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView

        navigation.setOnNavigationItemSelectedListener(this)
        loadFrag(home_frag())


    }
    private fun loadFrag(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .commit()


            return false
        }
        return true
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        var fragmenthere: Fragment? = null
        when (menuItem.itemId) {
            R.id.navigation_home -> fragmenthere = home_frag()
            R.id.navigation_bal -> fragmenthere = spend_frag()
            R.id.navigation_transactions -> fragmenthere = trans_frag()
        }

        loadFrag(fragmenthere)


        return true
    }

}
