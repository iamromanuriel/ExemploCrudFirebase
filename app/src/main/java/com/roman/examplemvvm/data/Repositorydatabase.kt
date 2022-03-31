package com.roman.examplemvvm.data

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class Repositorydatabase() {

    private var database : DatabaseReference
    private var datamutablelivedata : MutableLiveData<MutableList<User>>

    init {
        database = Firebase.database.getReference()
        datamutablelivedata = MutableLiveData()
        showdate()
    }
    fun getmutablelivedata() : MutableLiveData<MutableList<User>>{
        return datamutablelivedata
    }

    fun createnewuser(uid : String,name : String, lastname : String, agge : Int, date : String){
        var user = User(uid, name,lastname,agge,date)
        database.child("users").child(user.userId.toString()).setValue(user)
    }

    fun updateuser(uid : String,name : String, lastname : String, agge : Int, date : String){

    }

    fun showdate(){
        database.child("users").get().addOnSuccessListener {
            var listauser : MutableList<User> = mutableListOf()
            for(postSnapshot in it.children){
               var user : User? = postSnapshot.getValue(User::class.java)
                if (user != null) {
                    listauser.add(user)
                    datamutablelivedata.postValue(listauser)
                }
            }
            //datamutablelivedata.postValue(it)
        }
    }

    fun deleteuser(userid : String){
        database.child("users").child(userid).removeValue()
    }
}