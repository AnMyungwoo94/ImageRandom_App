package com.example.imagerandom_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagerandom_app.databinding.ActivityMainBinding
import com.example.imagerandom_app.mvc.MvcActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }
    }
        fun openMvc(){
            startActivity(Intent(this, MvcActivity::class.java))
        }
        fun openMvp(){

        }
        fun openMvvm(){

        }
        fun openMvi(){

        }
}