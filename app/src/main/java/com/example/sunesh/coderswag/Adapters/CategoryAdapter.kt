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
        val holder: ViewHolder
        val category = categories[position]
        if(convertView==null) {
            holder = ViewHolder()
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_view, null)
            holder.categoryname= categoryView.findViewById(R.id.categoryName)
            holder.categoryimage= categoryView.findViewById(R.id.categoryImage)
            categoryView.tag=holder
        }else{
            categoryView= convertView
            holder = convertView.tag as ViewHolder

        }
        holder.categoryname?.text = category.title
        val resourceId: Int = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryimage?.setImageResource(resourceId)
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
class ViewHolder{
    var categoryimage: ImageView? =null
    var categoryname: TextView? = null
}