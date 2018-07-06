package com.example.sunesh.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sunesh.coderswag.Model.Product
import com.example.sunesh.coderswag.R

class ProductAdapter(val context: Context, val products: List<Product>,val itemClick : (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {

        var view : View = LayoutInflater.from(context).inflate(R.layout.product_view,parent,false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder?.bindProducts(context,products[position],itemClick)
    }

    inner class ProductHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        val productName = itemView?.findViewById<TextView>(R.id.productName)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProducts(context: Context, product : Product, itemClick: (Product) -> Unit){

            val resourseId = context.resources.getIdentifier(product.image,"drawable",context.packageName)
            productImage?.setImageResource(resourseId)
            productName?.text=product.title
            productPrice?.text= product.price
            itemView.setOnClickListener { itemClick(product) }

        }
    }
}