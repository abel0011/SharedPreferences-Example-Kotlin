package com.idat.sharedpreferencesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idat.sharedpreferencesexample.UserVipApplication.Companion.prefs
import com.idat.sharedpreferencesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        checkUserValue()
    }

    private fun checkUserValue(){
        if(prefs.getName().isNotEmpty()){
            goToDetail()
        }
    }
    private fun initUI(){
        binding.btnContinue.setOnClickListener {
            accessToDetail()
        }
    }
    private fun accessToDetail(){
       if(binding.etName.text.isNotEmpty()){
           prefs.saveName(binding.etName.text.toString())
           prefs.saveVip(binding.cbVip.isChecked)
           goToDetail()
       }else{

       }
    }

    fun goToDetail(){
        startActivity(Intent(this,ResultActivity::class.java))
    }
}