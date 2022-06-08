package com.example.officeapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.officeapp.databinding.ActivityMainBinding
import com.example.officeapp.ui.home.HomeFragment
import com.example.officeapp.ui.home.HomeView

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