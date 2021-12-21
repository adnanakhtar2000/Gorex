package com.example.gorex.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R

class transection_fragment_Adapter(var order_number_transection : List<String> , var order_payment_transection : List<String> , var date_time_transection : List<String>) : RecyclerView.Adapter<transection_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): transection_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.transection_layout , parent , false)
        return transection_viewholder(view)
    }

    override fun onBindViewHolder(holder: transection_viewholder, position: Int) {
        holder.order_number_transection.text = order_number_transection[position]
        holder.order_payment_transeection.text = order_payment_transection[position]
        holder.date_time_transection.text= date_time_transection[position]

    }

    override fun getItemCount(): Int {
        return order_number_transection.size
    }
}

class transection_viewholder(itemView: View)  : RecyclerView.ViewHolder(itemView){

    var order_number_transection = itemView.findViewById<TextView>(R.id.textView8)
    var order_payment_transeection =itemView.findViewById<TextView>(R.id.textView9)
    var date_time_transection = itemView.findViewById<TextView>(R.id.date_time_transection)
}