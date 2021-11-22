package Product_And_Services_Fragment

import Adapters.Product_recycler_Adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.R
import com.example.gorex.databinding.FragmentProductBinding


class Product_Fragment : Fragment() {

    lateinit var productBinding: FragmentProductBinding
    var product_image : List<Int> = listOf(R.drawable.wheel1 , R.drawable.wheel1 , R.drawable.wheel1 , R.drawable.wheel1 , R.drawable.wheel1  )
    var product_name : List<String> = listOf("Pirelli Cinturato P7" , "Pirelli Cinturato P8" , "Pirelli Cinturato P7" , "Pirelli Cinturato P8")
    var product_price : List<String> = listOf("425 SR" , "425 SR" , "425 SR" , "425 SR")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productBinding = FragmentProductBinding.inflate(inflater , container , false)

        val recyclerView = productBinding.productFragmentRecyclerview
        recyclerView.adapter= Product_recycler_Adapter(product_image , product_name , product_price)
        recyclerView.layoutManager= GridLayoutManager(context , 2 , LinearLayoutManager.VERTICAL , false)


        return productBinding.root
    }


}