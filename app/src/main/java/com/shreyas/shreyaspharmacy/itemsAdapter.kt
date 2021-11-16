package com.shreyas.shreyaspharmacy

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class itemsAdapter(private val items1:List<Product>): RecyclerView.Adapter<itemsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.product_layout,parent,false)
        val holder = MyViewHolder(view)



        view.setOnClickListener {
            val intent = Intent(parent.context,ProductDetails::class.java)
            intent.putExtra("Title",items1[holder.adapterPosition].title)
            parent.context.startActivity(intent)
        }
        return holder

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val postion = items1[position]
        Picasso.get().load(items1[position].photoUrl).into(holder.image_sel)
        holder.Title.text = items1[position].title
        holder.price.text = items1[position].price.toString()

    }

    override fun getItemCount(): Int {
      return items1.size
    }


    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val image_sel = itemView.findViewById<ImageView>(R.id.image_sel)
        val Title = itemView.findViewById<TextView>(R.id.Txtview)
        val price = itemView.findViewById<TextView>(R.id.price)


    }


}