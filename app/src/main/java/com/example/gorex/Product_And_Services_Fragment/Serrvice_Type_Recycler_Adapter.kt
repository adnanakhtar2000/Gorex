package com.example.gorex.Product_And_Services_Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R

class Serrvice_Type_Recycler_Adapter(val wash_service : List<String> , val wash_service_price : List<String>) : RecyclerView.Adapter<service_type_viewholder>(){





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): service_type_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View= inflater.inflate(R.layout.wash_service_screen_layout , parent , false)
        return service_type_viewholder(view)
    }

    override fun onBindViewHolder(holder: service_type_viewholder, position: Int) {
        holder.wash_service_type.text = wash_service[position]
        holder.wash_service_price.text = wash_service_price[position]


    }


    override fun getItemCount(): Int {
        return wash_service.size
    }
}

class service_type_viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var wash_service_type = itemView.findViewById<CheckBox>(R.id.checkBox2)
    var wash_service_price = itemView.findViewById<TextView>(R.id.wash_services_price)


}