package com.shreyas.shreyaspharmacy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import java.net.URL
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductDetailsViewModel:  ViewModel() {

    val productDetails = MutableLiveData<Product>()

    fun fetchProductDetails(productTitle: String) {
        viewModelScope.launch(Dispatchers.Default) {
            val json =
                URL("https://api.jsonbin.io/b/60f17298a917050205c8bd84/1").readText()
            val list = Gson().fromJson(json, Array<Product>::class.java).toList()
            val product = list.first { it.title == productTitle }
            productDetails.postValue(product)

            //productDetails.postValue(product)
        }
    }

}