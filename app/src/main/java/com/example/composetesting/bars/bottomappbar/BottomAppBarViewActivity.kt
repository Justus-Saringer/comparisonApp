package com.example.composetesting.bars.bottomappbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.composetesting.R
import com.example.composetesting.databinding.BottomAppBarBinding

class BottomAppBarViewActivity : AppCompatActivity() {

    lateinit var binding: BottomAppBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BottomAppBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "BottomAppBar"

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        setCurrentFragment(firstFragment)

        binding.bottomAppBar.setOnMenuItemClickListener() {
            when (it.itemId) {
                R.id.first_fragment_icon -> {
                    setCurrentFragment(firstFragment)
                }
                R.id.second_fragment_icon -> {
                    setCurrentFragment(secondFragment)
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
}