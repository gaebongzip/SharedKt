package com.example.sharedkt

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null;
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()

        saveData()

    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val name = pref.getString("name","")
        binding.etHello.setText(name)
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val edit = pref.edit()
        edit.putString("name", binding.etHello.text.toString())
        edit.apply()

    }


}