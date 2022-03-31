package com.roman.examplemvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.roman.examplemvvm.R

class InfoActivity : AppCompatActivity() {

    private lateinit var email : TextView
    private lateinit var intentEmail : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        initView()
        initValues()
    }

    fun initView(){
        email = findViewById(R.id.textemail)
    }

    fun initValues(){
        intentEmail = intent.extras?.get("users") as String
        email.text = intentEmail
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.icondelete -> {
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.iconedit -> {
                var i = Intent(this, FormularioActivity::class.java)
                i.putExtra("edit", "Update")
                startActivity(i)
                //Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }


}