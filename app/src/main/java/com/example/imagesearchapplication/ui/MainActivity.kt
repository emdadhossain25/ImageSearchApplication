package com.example.imagesearchapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imagesearchapplication.R
import com.example.imagesearchapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


    }

}