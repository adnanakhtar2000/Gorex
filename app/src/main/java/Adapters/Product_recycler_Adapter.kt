package Adapters

import Interfaces.cellclicklistner
import Product_And_Services_Fragment.Product_Fragment
import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R
import org.w3c.dom.Text
import payment_history_fragment.Payment_History

class Product_recycler_Adapter(val cellclicklistner: cellclicklistner, val context: Product_Fragment, val product_image: List<Int>, val product_name: List<String>, val product_price: List<String> ) : RecyclerView.Adapter<product_recycler_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): product_recycler_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.products_screen_layout , parent , false)
        return product_recycler_viewholder(view)
    }

    override fun onBindViewHolder(holder: product_recycler_viewholder, position: Int) {
        holder.product_image.setImageResource(product_image[position])
        holder.product_name.text= product_name[position]
        holder.product_price.text = product_price[position]
        holder.product_image.setOnClickListener{
//cellclicklistner.onCellClickListener()
        }


    }

    override fun getItemCount(): Int {
      return   product_name.size
    }
}

class product_recycler_viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var product_image = itemView.findViewById<ImageView>(R.id.product_image)
    var product_name = itemView.findViewById<TextView>(R.id.product_name)
    var product_price = itemView.findViewById<TextView>(R.id.product_price)




}