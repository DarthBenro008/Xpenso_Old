package com.benrostudios.xpenso

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.room.Room
import com.benrostudios.xpenso.Data.AppDatabase
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import kotlinx.android.synthetic.main.transactions.*
import java.io.File

class trans_frag: Fragment() {
    lateinit var contexto: Context
    data class Transactions(val title: String, val year: String, val amount: Double)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragview = inflater.inflate(R.layout.transactions ,null)

        return fragview
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var nico = mutableListOf<Transactions>()
        var testTotal =0.0
        var testName = ""
        val thread = Thread{ var db= Room.databaseBuilder(contexto, AppDatabase::class.java,"TransHistory").build()
            db.historyDao().allHistory.forEach(){
                Log.i("Fetch Records2", "Id:  : ${it.entity}")
                Log.i("Fetch Records2", "Name:  : ${it.amt}")
                Log.i("Fetch Records2", "Name:  : ${it.timo}")
                nico.add(Transactions(it.entity,it.timo,it.amt))
                testTotal = testTotal + it.amt
                testName = testName + " " + it.entity
            }
        nico = nico.asReversed()
        }


        thread.start()
        try{
            thread.join()
            val filename = "myfile"
            val fileContents = ""+testTotal+"\n"+testName
            contexto.openFileOutput(filename, Context.MODE_PRIVATE).use {
                it.write(fileContents.toByteArray())
            }
            recyclerView.apply{
                layoutManager = LinearLayoutManager(activity)
                adapter = rec_adapter(nico){
                    Log.i("SAY hello", "Clicked!!!!!"+it.toString())
                    Log.i("SAY hello", nico[it].title)
                    Toast.makeText(context,nico[it].title,Toast.LENGTH_LONG).show()
                }
            }
            val linoo = contexto.openFileInput("myfile").bufferedReader().useLines { lines ->
                lines.fold("") { some, text ->
                    "$some\n$text"
                }
            }
            Toast.makeText(context,linoo,Toast.LENGTH_LONG).show()
            Log.i("Scooby", linoo)
        }catch(e: Exception){}
        Log.i("Fetch Records Gaandu", nico.toString())

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contexto = context
    }
}

