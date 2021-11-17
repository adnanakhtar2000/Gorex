package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R
import org.w3c.dom.Text

class Completed_order_adapter(val sp_name : List<String> , val payment_method : List<String> ,val service_name : List<String> ,val  payment : List<String> , val date_time : List<String> , val order_number : List<String>) : RecyclerView.Adapter<view_holder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): view_holder1 {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.orderhistory_table , parent , false)
        return view_holder1(view)
    }

    override fun onBindViewHolder(holder: view_holder1, position: Int) {
        holder.order_number.text = order_number[position]
        holder.service_provider.text = sp_name[position]
        holder.payment_method.text = payment_method[position]
        holder.service_name.text = service_name[position]
        holder.payment.text = payment[position]
        holder.date_time.text = date_time[position]
    }

    override fun getItemCount(): Int {
        return sp_name.size
    }

}

class view_holder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
   var order_number = itemView.findViewById<TextView>(R.id.order_number)
    var service_provider = itemView.findViewById<TextView>(R.id.service_provider_name)
    var payment_method = itemView.findViewById<TextView>(R.id.payment_method)
    var service_name = itemView.findViewById<TextView>(R.id.servic_name)
    var payment = itemView.findViewById<TextView>(R.id.payment)
    var date_time =itemView.findViewById<TextView>(R.id.date_time)

}