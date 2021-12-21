package com.example.gorex.Adapters

import com.example.gorex.Interfaces.cellclicklistner
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R

class Workshop_services_Adapter(val cellclicklistner: cellclicklistner ,val context: Context ,val service_logo : List<Int> , val service_name : List<String>) : RecyclerView.Adapter<workshop_services_viewholder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): workshop_services_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.our_services_layout , parent , false)
        return workshop_services_viewholder(view)
    }

    override fun onBindViewHolder(holder: workshop_services_viewholder, position: Int) {
       holder.service_logo.setImageResource(service_logo[position])
        holder.service_name.text= service_name[position]

        holder.service_name.setOnClickListener {
            cellclicklistner.onCellClickListener()
        }
    }

    override fun getItemCount(): Int {
        return service_name.size
    }
}

class workshop_services_viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val service_logo = itemView.findViewById<ImageView>(R.id.workshop_srvice_logo)
    val service_name = itemView.findViewById<TextView>(R.id.workshop_service_name)


}