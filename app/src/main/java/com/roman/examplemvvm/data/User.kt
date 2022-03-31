package com.roman.examplemvvm.data

import java.io.Serializable

data class User (val userId : String?=null, val name : String?=null, val lastname : String? = null, val age : Int?= null, val date : String?=null) : Serializable