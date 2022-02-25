package com.hoarauthomas.postgrest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModelMain by viewModels<ViewModelMainActivity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.textView)

        viewModelMain.callAPI()

        viewModelMain.liveCars().observe(this){
            if (it.isNotEmpty()){

                it.forEachIndexed { index, carsResponse ->
                    text.append(it[index].maker)
                }




            }
        }

    }
}