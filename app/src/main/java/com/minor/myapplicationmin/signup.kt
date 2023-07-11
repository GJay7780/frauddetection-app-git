package com.minor.myapplicationmin

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class signup : AppCompatActivity() {

    private lateinit var db:Dbhelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val pp = findViewById<Button>(R.id.ck)
        val sp = findViewById<Button>(R.id.signup)
       val namet = findViewById<EditText>(R.id.namet)
       val genet = findViewById<EditText>(R.id.gen)
       val paset = findViewById<EditText>(R.id.pet)
        val cpaet = findViewById<EditText>(R.id.cp)
        db = Dbhelper(this)

        pp.setOnClickListener {
            val ite = Intent(this,MainActivity::class.java)
            startActivity(ite)
        }
        sp.setOnClickListener {
            val namtext= namet.text.toString()
            val gentext = genet.text.toString()
            val pastext = paset.text.toString()
            val cpatext = cpaet.text.toString()
            val save = db.insertdata(namtext,gentext,pastext,cpatext)
            if(TextUtils.isEmpty(namtext) && TextUtils.isEmpty(gentext) && TextUtils.isEmpty(pastext) && TextUtils.isEmpty(cpatext)){
                Toast.makeText(this,"please fill details",Toast.LENGTH_SHORT).show()

            }
            else{
                if(pastext.equals(cpatext)){
                    if(save==true){
                        val cc= AlertDialog.Builder(this)
                        cc.setTitle("sucess")
                        cc.setMessage("sucessfully signed up")
                        cc.setPositiveButton("OK",DialogInterface.OnClickListener(){ dialogInterface, i ->
                            val inted = Intent(this,Loginpage::class.java)
                            startActivity(inted)
                        })
                        cc.show()
                    }
                    else{
                        Toast.makeText(this,"user already exist",Toast.LENGTH_SHORT).show()
                    }

                }
                else{
                    Toast.makeText(this,"Password not matched",Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}