package com.example.gorex.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R

class Order_parts_recycler_Adapter(val orders_name : List<String> , val orders_price : List<String>): RecyclerView.Adapter<Order_parts_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Order_parts_viewholder {
            val inflater : LayoutInflater = LayoutInflater.from(parent.context)
            val view : View = inflater.inflate(R.layout.parts_recycler_screen , parent , false)
            return Order_parts_viewholder(view)
    }

    override fun onBindViewHolder(holder: Order_parts_viewholder, position: Int) {
        holder.orders_name.text = orders_name[position]
        holder.orders_price.text = orders_price[position]
    }

    override fun getItemCount(): Int {
        return orders_name.size
    }
}

class Order_parts_viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var orders_name = itemView.findViewById<TextView>(R.id.orders_name)
    var orders_price = itemView.findViewById<TextView>(R.id.order_price)

}