package com.roman.examplemvvm.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roman.examplemvvm.data.Repositorydatabase
import com.roman.examplemvvm.data.User

class Viewmodeldatabase : ViewModel() {

    private var repositorie : Repositorydatabase
    var datasnopmutablelivedata : MutableLiveData<MutableList<User>>

    init{
        repositorie = Repositorydatabase()
        datasnopmutablelivedata = repositorie.getmutablelivedata()
    }

    fun databasewrite(){
        //repositorie.wrotedate()
    }

    fun tomakeconsult(){
        repositorie.showdate()
    }

    fun getshowdatasnop() : MutableLiveData<MutableList<User>>{
        return datasnopmutablelivedata
    }
}