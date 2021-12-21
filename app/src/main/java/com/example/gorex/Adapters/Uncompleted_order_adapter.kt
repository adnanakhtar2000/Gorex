package com.example.gorex.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R

class Uncompleted_order_adapter(val sp_name_uc : List<String> , val payment_method_uc : List<String> ,val service_name_uc : List<String> ,val  payment_uc : List<String> , val date_time_uc : List<String> , val order_number_uc : List<String>) : RecyclerView.Adapter<Uncompleted_order_adapter.view_holder_uncomplete>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): view_holder_uncomplete {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.uncomplete_order_history_detail , parent , false)
        return view_holder_uncomplete(view)
    }

    override fun onBindViewHolder(holder: view_holder_uncomplete, position: Int) {
        holder.order_number_uc.text = order_number_uc[position]
        holder.service_provider_uc.text = sp_name_uc[position]
        holder.payment_method_uc.text = payment_method_uc[position]
        holder.service_name_uc.text = service_name_uc[position]
        holder.payment_uc.text = payment_uc[position]
        holder.date_time_uc.text = date_time_uc[position]
    }

    override fun getItemCount(): Int {
        return sp_name_uc.size
    }
    class view_holder_uncomplete(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var order_number_uc = itemView.findViewById<TextView>(R.id.order_number_uc)
        var service_provider_uc = itemView.findViewById<TextView>(R.id.service_provider_name_uc)
        var payment_method_uc = itemView.findViewById<TextView>(R.id.payment_method_uc)
        var service_name_uc = itemView.findViewById<TextView>(R.id.servic_name_uc)
        var payment_uc = itemView.findViewById<TextView>(R.id.payment_uc)
        var date_time_uc =itemView.findViewById<TextView>(R.id.date_time_uc)
}



}