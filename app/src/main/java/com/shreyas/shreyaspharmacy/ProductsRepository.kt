package com.danielmalone.dansecommerce.repos


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shreyas.shreyaspharmacy.Product
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class ProductsRepository {




    fun getAllProducts(): Single<List<Product>> {
        return Single.create<List<Product>> {
            it.onSuccess(fetchProducts())
        }
    }



    fun getProductByName(name: String): Single<Product> {
        return Single.create<Product> {
            val product = fetchProducts().first { it.title == name }
            it.onSuccess(product)
        }
    }

    fun fetchProducts(): List<Product> {
        val json =
            URL("https://api.jsonbin.io/b/60f17298a917050205c8bd84/1").readText()
        return Gson().fromJson(json, Array<Product>::class.java).toList()
    }
}
