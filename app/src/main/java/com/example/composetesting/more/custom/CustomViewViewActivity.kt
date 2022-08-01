package com.example.composetesting.more.custom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composetesting.databinding.CustomViewLayoutBinding

class CustomViewViewActivity : AppCompatActivity() {

    private var binding: CustomViewLayoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CustomViewLayoutBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            custom.setData(
                mutableListOf(
                    "This is a bullet",
                    "This is another bullet",
                    "This is another bullet"
                )
            )
        }
    }
}