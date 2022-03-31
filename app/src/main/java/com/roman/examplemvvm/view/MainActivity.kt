package com.roman.examplemvvm.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.roman.examplemvvm.util.Dialog
import com.roman.examplemvvm.R
import com.roman.examplemvvm.data.User
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val viewmodel : Viewmodeldatabase by viewModels()
    lateinit var buttonadd : FloatingActionButton

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycle_view)
        val adaoter : Recycleviewadapter = Recycleviewadapter()
        buttonadd = findViewById(R.id.button_add)

        viewmodel.getshowdatasnop().observe(this, Observer {data ->
            if(data != null){

                    adaoter.RecyclerView(data,this, supportFragmentManager)

                //configuracion de recyclerview
                recyclerView.hasFixedSize()
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adaoter
            }
        })
        buttonadd.setOnClickListener {
            //val sdg = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            //val currentDateFormat = sdg.format(Date())



            var intent = Intent(this,FormularioActivity::class.java)
            intent.putExtra("input","Register")
            startActivity(intent)

        }
    }
}