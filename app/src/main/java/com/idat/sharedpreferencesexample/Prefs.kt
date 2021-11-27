package com.idat.sharedpreferencesexample

import android.content.Context

class Prefs(val context:Context) {
    //nombre base de datos
    val SHARED_NAME = "Mydtb"

    val SHARED_USER_NAME = "username"

    val SHARED_VIP = "vip"
    //ingresando modo0
    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveName(name:String){
        //edita nuestra base de datos para añadir un valor
        //editando el nombre con el que ingresa el usuario
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun saveVip(vip:Boolean){
        //aply para que se apliquen los cambios
       storage.edit().putBoolean(SHARED_VIP, vip).apply()
    }

    fun getName():String{
        //el valor por defecto es vacio
        return storage.getString(SHARED_USER_NAME, "")!!
    }
    fun getVip():Boolean{
        return storage.getBoolean(SHARED_VIP,false)
    }
    fun wipe(){
        storage.edit().clear().apply()
    }
}