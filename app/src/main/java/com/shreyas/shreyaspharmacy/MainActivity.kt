package com.shreyas.shreyaspharmacy

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
/*import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread*/
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dtalist = findViewById<RecyclerView>(R.id.recyclerview)

        GlobalScope.async {
            val json = URL("https://api.jsonbin.io/b/60f17298a917050205c8bd84/1").readText()
            withContext(Main){
                val products = Gson().fromJson(json,Array<Product>::class.java).toList()
                dtalist.apply {
                    layoutManager = GridLayoutManager(this@MainActivity,2)
                    adapter = itemsAdapter(products)


                }
            }
        }




    }
    }

