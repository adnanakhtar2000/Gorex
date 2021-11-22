package Adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R
import org.w3c.dom.Text

class service_recycler_Adapter (val service_image : List<Int> , val service_name : List<String> , val service_price : List<String> ) : RecyclerView.Adapter<service_recycler_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): service_recycler_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.services_screen_layout , parent , false)
        return service_recycler_viewholder(view)
    }

    override fun onBindViewHolder(holder: service_recycler_viewholder, position: Int) {
        holder.service_image.setImageResource(service_image[position])
        holder.service_name.text= service_name[position]
        holder.service_price.text = service_price[position]
    }

    override fun getItemCount(): Int {
      return   service_name.size
    }
}

class service_recycler_viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var service_image = itemView.findViewById<ImageView>(R.id.service_background)
    var service_name = itemView.findViewById<TextView>(R.id.car_wash_services)
    var service_price = itemView.findViewById<TextView>(R.id.service_price)




}