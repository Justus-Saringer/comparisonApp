package com.example.composetesting.bars.toolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composetesting.databinding.ToolbarBinding

class ToolbarViewActivity: AppCompatActivity() {

    private var binding: ToolbarBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ToolbarBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.toolbarExample?.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}