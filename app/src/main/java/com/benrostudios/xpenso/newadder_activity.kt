package com.benrostudios.xpenso

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.benrostudios.xpenso.Data.AppDatabase
import com.benrostudios.xpenso.Data.TransHistory
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.newadder.*
import java.text.SimpleDateFormat
import java.util.*


class newadder_activity : AppCompatActivity() {
    var phyvirtu: String = ""
    var categ: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newadder)
        chip4.setText("Food")
        chip5.setText("Travel")
        chip6.setText("Entertainment")
        chip7.setText("Stationery")
        chip8.setText("Misc")

        phyvirtu_chip_group.setOnCheckedChangeListener{ group, checkedId:Int ->
            val chip: Chip? = findViewById(checkedId)
            chip?.let{
                Toast.makeText(applicationContext,it.text,Toast.LENGTH_LONG).show()
                phyvirtu = it.text.toString()
            }
        }
        categ_chip_group.setOnCheckedChangeListener{ group, checkedId:Int ->
            val chip: Chip? = findViewById(checkedId)
            chip?.let{
                Toast.makeText(applicationContext,it.text,Toast.LENGTH_LONG).show()
                categ = it.text.toString()
            }
        }
        var db= Room.databaseBuilder(applicationContext, AppDatabase::class.java,"TransHistory").build()
        addo.setOnClickListener {
            val nameop: String = nameo.text.toString()
            val amto: Double = amt.text.toString().toDouble()
            val descp: String = descp.text.toString()
            Toast.makeText(applicationContext, nameop+" "+ amto+" "+descp+" "+phyvirtu, Toast.LENGTH_LONG).show()
            val thread = Thread{
                    var henlo: TransHistory= TransHistory()
                    henlo.amt = amto
                    henlo.entity = nameop
                    henlo.descp = descp
                    henlo.pv = phyvirtu
                    val currentTime = Calendar.getInstance().getTime()
                    val timeFormat = SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa")
                    val output = timeFormat.format(currentTime)
                    henlo.timo = output
                    henlo.type = categ
                    db.historyDao().insert(henlo)

                    db.historyDao().allHistory.forEach(){
                        Log.i("Fetch Records", "Id:  : ${it.entity}")
                        Log.i("Fetch Records", "Name:  : ${it.amt}")
                        Log.i("Fetch Records", "Name:  : ${it.timo}")
                    }

            }
            thread.start()

            }

    }

}
