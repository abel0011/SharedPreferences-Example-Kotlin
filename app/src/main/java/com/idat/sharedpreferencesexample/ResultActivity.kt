package com.idat.sharedpreferencesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.idat.sharedpreferencesexample.UserVipApplication.Companion.prefs
import com.idat.sharedpreferencesexample.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

   private lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    private fun initUI(){
        binding.btnBack.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }
            val userName = prefs.getName()

            binding.tvName.text = "Welcome $userName"
            if(prefs.getVip()){
                setVipColorBackground()
            }

    }
    private fun setVipColorBackground(){
       binding.activityContainer.setBackgroundColor(ContextCompat.getColor(this,R.color.vip_green))
    }
}