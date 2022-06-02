package com.example.officeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.officeapp.databinding.ActivityMainBinding

/* `MainActivity` is a class that extends `AppCompatActivity` and is responsible for the main activity
of the app */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}