package com.example.composetesting.layouts.constraintlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composetesting.R

class ConstraintLayoutViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.constraintlayout)
        supportActionBar?.title = "ConstraintLayout"
    }
}