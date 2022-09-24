package com.internshala.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(){

    lateinit var MobileNum:EditText
    lateinit var etPassword:EditText
    lateinit var btnLogin :Button
    lateinit var txtForgotPassword:TextView
    lateinit var txtRegister:TextView
    val validMobileNo="9169254387"
    val validPassword = arrayOf("Anna","Mulan","Elsa","Poca","Merida","Rapunzal")

    lateinit var sharedPreferences: SharedPreferences //DECLARIN SARED PREFERNCEVARIABLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name)
            ,Context.MODE_PRIVATE)  //CREATIN OBJECT OF SARED PREFERNCE CLASS

        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
         setContentView(R.layout.activity_login)

        if(isLoggedIn) {
            val intent = Intent(this@LoginActivity, DisneyActivity::class.java)
            startActivity(intent)
            finish()
        }
      //  else {
         //   setContentView(R.layout.activity_login)
       // }
        title = "Log In"

        MobileNum = findViewById(R.id.MobileNo)
        etPassword = findViewById(R.id.Password)
        btnLogin = findViewById(R.id.Button)
        txtForgotPassword = findViewById(R.id.Forgotpass)
        txtRegister = findViewById(R.id.register)



        btnLogin.setOnClickListener {
            val mobileNo = MobileNum.text.toString() //we are not puttin tis b before on create as
            // we will et te data after activity is created
            val Password = etPassword.text.toString()


            val intent = Intent(this@LoginActivity, DisneyActivity::class.java)

            if (mobileNo == validMobileNo) {
                if (Password == validPassword[0]) {

                   var DisName = "Anna of"
                    savePreferences (DisName)
                //    intent.putExtra("Name",DisName)
                    startActivity(intent)
                } else if (Password == validPassword[1]) {

                     var DisName = "Mulan"
                    savePreferences (DisName)
                   // intent.putExtra("Name",DisName)
                    startActivity(intent)
                } else if (Password == validPassword[2]){

                   var DisName = "Elsa"
                    savePreferences (DisName)

                startActivity(intent)
            } else if (Password == validPassword[3])
            {
              var  DisName = "Poca"
                savePreferences (DisName)
              //  intent.putExtra("Name",DisName)
                startActivity(intent)

            } else if (Password == validPassword[4])
        {
                var DisName = "Merida"
            savePreferences (DisName)
           // intent.putExtra("Name",DisName)
            startActivity(intent)

        } else if(Password == validPassword[5])
        {
            var DisName = "Rapunzal"
            savePreferences (DisName)
          //  intent.putExtra("Name",DisName)
        startActivity(intent)
    }
            else
        {
            Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG)
                .show()
        }
    }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences (title:String)
    {
sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()

    }


}
