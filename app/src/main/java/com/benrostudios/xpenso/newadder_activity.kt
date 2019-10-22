package com.benrostudios.xpenso

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.home.*
import kotlinx.android.synthetic.main.newadder.*

class newadder_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newadder)
        choice_chip_group.setOnCheckedChangeListener{group,checkedId:Int ->
            val chip: Chip? = findViewById(checkedId)
            chip?.let{
                Toast.makeText(applicationContext,it.text,Toast.LENGTH_LONG).show()
            }
        }
        addo.setOnClickListener {
            val nameop: String? = nameo.text.toString()
            val amto: String? = amt.text.toString()
            val phy: String? = phy.text.toString()
            Toast.makeText(applicationContext, nameop+" "+ amto+" "+phy, Toast.LENGTH_LONG).show()

            }

    }

}
