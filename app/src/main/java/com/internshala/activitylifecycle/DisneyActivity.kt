package com.internshala.activitylifecycle

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DisneyActivity : AppCompatActivity()
{
    var titleName:String? = "xyz"
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name)
            ,Context.MODE_PRIVATE)

        setContentView(R.layout.scrollview_example)
        println("onCreate" +
                "called")
     //   if(intent!=null) {    //we dont need tis block we will extract title from sared prefernce
      //      titleName = intent.getStringExtra("Name")
    //    }
titleName=sharedPreferences.getString("Title","princess")
        title= titleName
    }

   /* override fun onStart() {
        super.onStart()
        println("onStart called")
    }

    override fun onResume() {
        super.onResume()
        println("onResume  called")
    }

    override fun onPause() {
        super.onPause()
        println("onPause called")
    }

    override fun onStop() {
        super.onStop()
        println("onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        println("onReStart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy called")
    }*/

}