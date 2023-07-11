package com.minor.myapplicationmin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Dbhelper(context:Context):SQLiteOpenHelper(context,"user",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table userdata(name varchar primary key,gender varchar,password varchar,confirmpassword varchar)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("drop table if exists userdata")
    }
    fun insertdata(name:String,gender:String,password:String,confirmpassword:String):Boolean {
     val db = this.writableDatabase
     val lo = ContentValues()
     lo.put("name",name)
        lo.put("gender",gender)
        lo.put("password",password)
        lo.put("confirmpassword",confirmpassword)
        val res = db.insert("userdata",null,lo)
        if(res==-1.toLong()){
            return false
        }
        return true

    }
    fun checkdet(name:String,password:String):Boolean{
        val db = this.writableDatabase
        val query = "select * from userdata where name='$name' and password='$password'"
        val cursor = db.rawQuery(query,null)
        if(cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true

    }
}
