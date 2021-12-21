package com.example.gorex.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R

class Card_fragment_Adapter(val card_logo : List<Int>  , val card_holder_name : List<String> , val expiry_date : List<String>) : RecyclerView.Adapter<card_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): card_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.card_layout , parent , false)
        return card_viewholder(view)
    }

    override fun onBindViewHolder(holder: card_viewholder, position: Int) {
       holder.card_logo.setImageResource(card_logo[position])
        holder.card_holder_name.text = card_holder_name[position]
        holder.expiray_date.text = expiry_date[position]

    }

    override fun getItemCount(): Int {
       return card_holder_name.size
    }
}
class card_viewholder(itemView: View)  : RecyclerView.ViewHolder(itemView){

var card_logo = itemView.findViewById<ImageView>(R.id.car_logo)
    var car_number = itemView.findViewById<TextView>(R.id.credit_card_number)
    var card_holder_name =itemView.findViewById<TextView>(R.id.card_holder_name)
    var expiray_date = itemView.findViewById<TextView>(R.id.expires_date)

}