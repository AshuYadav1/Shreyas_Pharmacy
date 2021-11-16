package com.shreyas.shreyaspharmacy

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.danielmalone.dansecommerce.repos.ProductsRepository
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails: AppCompatActivity() {
    lateinit var viewModel: ProductDetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val photo = findViewById<ImageView>(R.id.photo)
        val thePriceOfProduct = findViewById<TextView>(R.id.thePriceOfProduct)
        val product_name = findViewById<TextView>(R.id.product_name)



        //viewModel.fetchProductDetails(title)

        addToCartButton.setOnClickListener {
         Toast.makeText(applicationContext,"Your item has been successfully Added to cart",Toast.LENGTH_LONG).show()
        }



        availability.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("please call on this numbe rto buy +91800000000")
                .setPositiveButton("OK") { p0, p1 ->

                }
                .create()
                .show()
        }
    }

}