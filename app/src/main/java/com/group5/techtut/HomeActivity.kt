package com.group5.techtut

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.widget.Button
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_about.view.*


class HomeActivity:AppCompatActivity(){
    private var flag = true
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        about.setOnClickListener {
            if (flag) {
                val window = PopupWindow(this)
                val view = layoutInflater.inflate(R.layout.activity_about, null)
                window.contentView = view

                val close = view.findViewById<Button>(R.id.close)
                close.setOnClickListener {
                    window.dismiss()
                    flag = true
                }
                window.elevation = 10.0F

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    // Create a new slide animation for popup window enter transition
                    val slideIn = Slide()
                    slideIn.slideEdge = Gravity.TOP
                    window.enterTransition = slideIn

                    // Slide animation for popup window exit transition
                    val slideOut = Slide()
                    slideOut.slideEdge = Gravity.END
                    window.exitTransition = slideOut

                }
                TransitionManager.beginDelayedTransition(root_layout)
                window.showAtLocation(root_layout, Gravity.CENTER, 0, 0)
                readAbout(view)
                flag = false
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun readAbout(view: View) {
                view.textView.text = "About\ncomes\nhere"
            }
}