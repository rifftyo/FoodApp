package com.rifftyo.food

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    private lateinit var myName: TextView
    private lateinit var myEmail: TextView
    private lateinit var myPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        myName = findViewById(R.id.my_name)
        myEmail = findViewById(R.id.my_email)
        myPhoto = findViewById(R.id.my_foto)
    }
}