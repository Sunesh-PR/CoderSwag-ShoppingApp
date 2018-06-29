package com.example.sunesh.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.sunesh.coderswag.Model.Category
import com.example.sunesh.coderswag.R

class CategoryAdapter(context: Context, categories : List<Category>) : BaseAdapter(){
    val categories = categories
    val context = context
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val category = categories[position]
        categoryView = LayoutInflater.from(context).inflate(R.layout.category_view, null)
        val categoryname: TextView = categoryView.findViewById(R.id.categoryName)
        val categoryimage: ImageView = categoryView.findViewById(R.id.categoryImage)
        categoryname.text = category.title
        val resourceId: Int = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        categoryimage.setImageResource(resourceId)
        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

}