package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R
import org.w3c.dom.Text

class cancalled_order_adapter(val sp_name_c : List<String> , val payment_method_c : List<String> ,val service_name_c : List<String> ,val  payment_c : List<String> , val date_time_c : List<String> , val order_number_c : List<String>) : RecyclerView.Adapter<view_holder_cancelled>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): view_holder_cancelled {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.cancelled_order_history_detail , parent , false)
        return view_holder_cancelled(view)
    }

    override fun onBindViewHolder(holder: view_holder_cancelled, position: Int) {
        holder.order_number.text = order_number_c[position]
        holder.service_provider.text = sp_name_c[position]
        holder.payment_method.text = payment_method_c[position]
        holder.service_name.text = service_name_c[position]
        holder.payment.text = payment_c[position]
        holder.date_time.text = date_time_c[position]
    }

    override fun getItemCount(): Int {
        return sp_name_c.size
    }

}

class view_holder_cancelled(itemView: View) : RecyclerView.ViewHolder(itemView) {
   var order_number = itemView.findViewById<TextView>(R.id.order_number_c)
    var service_provider = itemView.findViewById<TextView>(R.id.service_provider_name_c)
    var payment_method = itemView.findViewById<TextView>(R.id.payment_method_c)
    var service_name = itemView.findViewById<TextView>(R.id.servic_name_c)
    var payment = itemView.findViewById<TextView>(R.id.payment_c)
    var date_time =itemView.findViewById<TextView>(R.id.date_time_c)

}