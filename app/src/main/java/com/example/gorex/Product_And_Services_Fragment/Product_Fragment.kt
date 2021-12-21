package com.example.gorex.Product_And_Services_Fragment

import com.example.gorex.Adapters.Product_recycler_Adapter
import com.example.gorex.Interfaces.cellclicklistner
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.activity.Orders_Details_Fragment
import com.example.gorex.R
import com.example.gorex.databinding.FragmentProductBinding


class Product_Fragment : Fragment() , cellclicklistner {
    lateinit var ordersDetailsFragment: Orders_Details_Fragment

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
        recyclerView.adapter= Product_recycler_Adapter(this , this , product_image , product_name , product_price)
        recyclerView.layoutManager= GridLayoutManager(context , 2 , LinearLayoutManager.VERTICAL , false)


        return productBinding.root
    }

    override fun onCellClickListener() {
       val fm : FragmentManager = childFragmentManager
      val ft : FragmentTransaction = fm.beginTransaction().replace(R.id.product_and_services_viewpager ,ordersDetailsFragment)
        ft.commit()

    }


}