package com.group5.techtut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        about.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}