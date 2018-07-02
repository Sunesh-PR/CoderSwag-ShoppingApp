package com.example.sunesh.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.sunesh.coderswag.Adapters.CategoryAdapter
import com.example.sunesh.coderswag.Adapters.CategoryRecyclerAdapter
import com.example.sunesh.coderswag.Model.Category
import com.example.sunesh.coderswag.R
import com.example.sunesh.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//  lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,DataService.categories)
//        val listAdapter : CategoryAdapter
//        listAdapter = CategoryAdapter(this,DataService.categories)
        val adapter = CategoryRecyclerAdapter(this,DataService.categories)

        CategoryListView.adapter= adapter

        val layoutManager = LinearLayoutManager(this)
        CategoryListView.layoutManager = layoutManager
        CategoryListView.setHasFixedSize(false)

    }
}
