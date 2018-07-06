package com.example.sunesh.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.sunesh.coderswag.Adapters.ProductAdapter
import com.example.sunesh.coderswag.R
import com.example.sunesh.coderswag.Services.DataService
import com.example.sunesh.coderswag.Utilities.EXTRA_FINAL
import com.example.sunesh.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val categoryType=intent.getStringExtra(EXTRA_PRODUCT)
        val adapter = ProductAdapter(this,DataService.getProducts(categoryType)){product ->
            val finalIntent = Intent(this, FinalActivity::class.java)
            finalIntent.putExtra(EXTRA_FINAL,product)
            startActivity(finalIntent)
        }

        val orientation = resources.configuration.orientation
        var spanCount =2

        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount =3
        }
        val screensize = resources.configuration.screenHeightDp
        if(screensize > 720){
            spanCount =3
        }
        val layoutManager = GridLayoutManager(this,spanCount)
        ProductListView.adapter = adapter
        ProductListView.layoutManager = layoutManager

    }
}
