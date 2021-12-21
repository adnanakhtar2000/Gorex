package com.example.gorex.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R

class My_vehicle_Adapter(val vehicle_image : List<Int> , val vehicle_name : List<String> , val brand_name : List<String> , val model_year : List<String> , val vehicle_type : List<String>  , val vehicle_number : List<String>) : RecyclerView.Adapter<myVehicle_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myVehicle_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.my_vehicle_design , parent , false)
        return myVehicle_viewholder(view)
    }

    override fun onBindViewHolder(holder: myVehicle_viewholder, position: Int) {
        holder.vehicle_Image.setImageResource(position)
        holder.vehicle_name.text = vehicle_name[position]
        holder.brand_name.text = brand_name[position]
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}

class  myVehicle_viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val vehicle_Image = itemView.findViewById<ImageView>(R.id.vehicle_type_images)
    val vehicle_name = itemView.findViewById<TextView>(R.id.textView14)
    val brand_name = itemView.findViewById<TextView>(R.id.textView12)
    val model_year = itemView.findViewById<TextView>(R.id.textView13)
    val vehicle_type = itemView.findViewById<TextView>(R.id.model_type)
    val vahicle_number = itemView.findViewById<TextView>(R.id.vehicle_number)


}