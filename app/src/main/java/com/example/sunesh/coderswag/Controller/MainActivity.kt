package com.example.sunesh.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.sunesh.coderswag.Adapters.CategoryRecyclerAdapter
import com.example.sunesh.coderswag.R
import com.example.sunesh.coderswag.Services.DataService
import com.example.sunesh.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//  lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,DataService.categories)
//        val listAdapter : CategoryAdapter
//        listAdapter = CategoryAdapter(this,DataService.categories)
        val adapter = CategoryRecyclerAdapter(this,DataService.categories){category ->
            val productIntent = Intent(this, ProductActivity::class.java)
            productIntent.putExtra(EXTRA_PRODUCT,category.title)
            startActivity(productIntent)

        }

        CategoryListView.adapter= adapter

        val layoutManager = LinearLayoutManager(this)
        CategoryListView.layoutManager = layoutManager
        CategoryListView.setHasFixedSize(false)

    }
}
