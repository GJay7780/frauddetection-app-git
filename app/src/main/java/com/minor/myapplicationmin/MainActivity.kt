package com.minor.myapplicationmin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lo = findViewById<Button>(R.id.login)
        val si = findViewById<Button>(R.id.signup)

        lo.setOnClickListener {
           val ite = Intent(this,Loginpage::class.java)
            startActivity(ite)
        }
        si.setOnClickListener {
            val its = Intent(this,signup::class.java)
            startActivity(its)
        }

    }


}