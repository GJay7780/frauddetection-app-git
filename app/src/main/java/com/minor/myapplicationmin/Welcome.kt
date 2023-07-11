package com.minor.myapplicationmin

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val c = findViewById<Button>(R.id.sf)
        val boy = findViewById<ImageView>(R.id.sd)
        val anmi = boy.drawable as AnimationDrawable
        anmi.start()
        anmi.start()
        c.setOnClickListener {
            val intes = Intent(this,MainActivity::class.java)
            startActivity(intes)
            val funjbb = AnimationUtils.loadAnimation(this,R.anim.zoom)
            c.startAnimation(funjbb)
        }
    }


}