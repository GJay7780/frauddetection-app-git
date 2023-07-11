package com.minor.myapplicationmin

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Loginpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)
        val lo = findViewById<Button>(R.id.lop)
        val ba = findViewById<Button>(R.id.ba)
        val naet = findViewById<EditText>(R.id.unm)
        val pass = findViewById<EditText>(R.id.sin)

         val db = Dbhelper(this)

        ba.setOnClickListener {
            val itb = Intent(this,MainActivity::class.java)
            startActivity(itb)
        }
        lo.setOnClickListener {
            val pwffs = naet.text.toString()
            val seddf = pass.text.toString()
            if(TextUtils.isEmpty(pwffs) && TextUtils.isEmpty(seddf)){
                Toast.makeText(this,"fill the fields",Toast.LENGTH_SHORT).show()

            }
            else {
                   val khh = db.checkdet(pwffs, seddf)
                   if(khh == true){
                       val mou = AlertDialog.Builder(this)
                       mou.setTitle("solution")
                       mou.setMessage("Sucessfully Login")
                       mou.setPositiveButton("welcome",DialogInterface.OnClickListener(){ dialogInterface, i ->
                           val duvre = Intent(this,procees::class.java)
                           startActivity(duvre)
                       })
                       mou.show()


                   }
                else{
                     Toast.makeText(this,"wrong password and wrong user",Toast.LENGTH_SHORT).show()
                   }
            }
        }

    }
}