package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R

class Order_TypeAdapter(val order_name : List<String> , val order_images : List<Int>): RecyclerView.Adapter<view_holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): view_holder {
      val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.order_type_item_view , parent , false)
        return view_holder(view)
    }

    override fun onBindViewHolder(holder: view_holder, position: Int) {
        holder.order_name.text = order_name[position]
        holder.order_image.setImageResource(order_images[position])
    }

    override fun getItemCount(): Int {
        return order_name.size
    }
}

class view_holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var order_name = itemView.findViewById<TextView>(R.id.order_name)
    var order_image = itemView.findViewById<ImageView>(R.id.order_image)

}