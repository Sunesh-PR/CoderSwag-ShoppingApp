package com.example.sunesh.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sunesh.coderswag.Model.Product
import com.example.sunesh.coderswag.R
import com.example.sunesh.coderswag.Utilities.EXTRA_FINAL
import kotlinx.android.synthetic.main.activity_final.*

class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        val product = intent.getParcelableExtra<Product>(EXTRA_FINAL)
        finalName.text=product.title
        val resourceId = this.resources.getIdentifier(product.image,"drawable",this.packageName)
        finalImage.setImageResource(resourceId)
        finalPrice.text = "PRICE: ${product.price}"
        finalBtn.setOnClickListener{
            Toast.makeText(this,"You Bought ${product.title}, Congrats",Toast.LENGTH_SHORT).show()
        }
    }
}
