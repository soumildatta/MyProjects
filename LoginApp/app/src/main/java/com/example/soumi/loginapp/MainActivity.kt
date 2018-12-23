package com.example.soumi.loginapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameText = findViewById<EditText>(R.id.usernameText)
        val passwordText = findViewById<EditText>(R.id.passwordText)
        val textView = findViewById<TextView>(R.id.textView)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            authenticate(usernameText.getText().toString(), passwordText.getText().toString())
        }
    }

    fun authenticate (username: String, password: String){
        //user registration incomplete
        if(username == "Soumil" && password == "1234"){

            //intent
            //goes to next page
            val intent = Intent(this, LoggedActivityOne::class.java)
            startActivity(intent)
        }
    }
}
