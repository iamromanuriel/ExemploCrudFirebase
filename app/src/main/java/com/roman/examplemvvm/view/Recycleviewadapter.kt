package com.roman.examplemvvm.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.roman.examplemvvm.util.Dialog
import com.roman.examplemvvm.R
import com.roman.examplemvvm.data.User

class Recycleviewadapter : RecyclerView.Adapter<Recycleviewadapter.ViewHolder>(){

    var users : MutableList<User> = ArrayList()
    lateinit var context : Context
    lateinit var manager: FragmentManager
    lateinit var dialog : Dialog
    fun RecyclerView (users: MutableList<User>, context: Context, manager : FragmentManager){
        this.users = users
        this.context = context
        this.manager = manager
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val iduser : TextView
        val emailuser : TextView
        val btndelete : ImageButton

        init {
            iduser = view.findViewById(R.id.tv_title)
            emailuser = view.findViewById(R.id.tv_desc)
            btndelete = view.findViewById(R.id.btndelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.iduser.text = users[position].userId
        holder.emailuser.text = users[position].name

       holder.itemView.setOnClickListener {
           var intent = Intent(holder.itemView.context, InfoActivity::class.java)
           intent.putExtra("users", users[position].name)
           holder.itemView.context.startActivity(intent)
       }
       holder.btndelete.setOnClickListener {
           dialog = Dialog()
           dialog.DialogInit(users[position].userId.toString())
           dialog.show(manager, "customDialog")

       }

    }


    override fun getItemCount(): Int {
        return users.size
    }
}