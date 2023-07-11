package com.minor.myapplicationmin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.io.File
import java.util.jar.Manifest
import android.net.Uri
import android.provider.DocumentsContract
import android.util.Log;
import android.widget.TextView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import java.io.BufferedReader
import java.io.InputStreamReader


class procees : AppCompatActivity() {
    private val PICK_FILE_REQUEST = 1
    private var mo=false
    private var locationsd= ""
    public var filePath = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_procees)
        val dkd = findViewById<Button>(R.id.bm)
        val dwf = findViewById<ImageView>(R.id.ipl)
        val nbk = findViewById<Button>(R.id.runnn)

        nbk.setOnClickListener {


            // Pass the file path to the Python code using Chaquopy
            if(mo == true) {

                val ss = filePath
                val mk = ss.toString()
                val result = Python.getInstance().getModule("test2").callAttr("wwe",mk)
                val loe = findViewById<TextView>(R.id.wri)
                loe.setText(result.toString())
            }
            else{
                Toast.makeText(this,"import file",Toast.LENGTH_LONG).show()
            }

        }

        dkd.setOnClickListener {

            val ite = Intent(this, MainActivity::class.java)
            startActivity(ite)
        }

        dwf.setOnClickListener { true
            mo = true
            Toast.makeText(this, "file manger is opening", Toast.LENGTH_LONG).show()
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"
            startActivityForResult(intent, 1)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                val uri = data?.data
                val path :String = this.filesDir.absolutePath

//                val file : File = File(path+)
                val filePath = uri?.path

                if (filePath != null) {
                    Log.d("data uri ---->",filePath)

                }
                Toast.makeText(this,filePath,Toast.LENGTH_LONG).show()
                if (!Python.isStarted()) {
                    Python.start(AndroidPlatform(this))
                }



            }
        }
    }
}





/* private fun getPath(uri: Uri): String? {
     val wholeID = DocumentsContract.getDocumentId(uri)
     val id = wholeID.split(":")[1]
     val column = arrayOf(MediaStore.Images.Media.DATA)
     val sel = MediaStore.Images.Media._ID + "=?"
     val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, column, sel, arrayOf(id), null)
     var filePath: String? = null
     cursor?.let {
         it.moveToFirst()
         val columnIndex = cursor.getColumnIndex(column[0])
         filePath = cursor.getString(columnIndex)
         cursor.close()        }
     return filePath
 } */
/* private fun readCsvFileLocation(): String {

     val filePath = "path/to/your/csv/file.csv"
     return filePath
 } */