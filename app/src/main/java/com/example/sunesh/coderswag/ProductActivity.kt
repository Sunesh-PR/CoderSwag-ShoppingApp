package com.example.sunesh.coderswag

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sunesh.coderswag.Utilities.EXTRA_PRODUCT

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val categoryType=intent.getStringExtra(EXTRA_PRODUCT)
        println(categoryType)
    }
}
