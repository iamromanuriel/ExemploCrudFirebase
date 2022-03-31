package com.roman.examplemvvm.view

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.roman.examplemvvm.R
import com.roman.examplemvvm.data.Repositorydatabase
import java.text.SimpleDateFormat
import java.util.*

class FormularioActivity : AppCompatActivity() {
    private lateinit var submit : Button
    private lateinit var nameedit : EditText
    private lateinit var lastnameedit : EditText
    private lateinit var aggeedit : EditText
    var repository = Repositorydatabase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)
        submit = findViewById(R.id.buttonsubmit)
        nameedit = findViewById(R.id.editname)
        lastnameedit = findViewById(R.id.editlastname)
        aggeedit = findViewById(R.id.editagge)

        var intentupdate = intent.extras?.get("edit")
        var intentregister = intent.extras?.get("input")

        if(intentupdate != null){
            submit.text = intentupdate.toString()
        }
        if(intentregister != null){
            //submit.text =
        }

        submit.setOnClickListener {
            var uid = UUID.randomUUID().toString()
            val name = nameedit.text.toString()
            val lastname = lastnameedit.text.toString()
            val agge = aggeedit.text.toString().toInt()
            val sdg = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val date = sdg.format(Date()).toString()

            if(intentupdate != null){

            }
            if(intentregister != null){
                repository.createnewuser(uid,name,lastname,agge,date)
            }

        }
    }


}