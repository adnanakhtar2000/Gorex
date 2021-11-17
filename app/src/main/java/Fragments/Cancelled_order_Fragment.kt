package Fragments

import Adapters.cancalled_order_adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.R
import com.example.gorex.databinding.FragmentCancelledOrderBinding
import com.example.gorex.databinding.FragmentInCompleteOrderBinding


class Cancelled_order_Fragment : Fragment() {
lateinit var  cancelledOrderBinding: FragmentCancelledOrderBinding
    val order_number_c : List<String> = listOf("A5409009801" )
    val provider_name_c : List<String> = listOf("Auto Master"  )
    val Payment_Method_c : List<String> = listOf("Cash" )
    val service_name_c : List<String> = listOf("Engine Oil" )
    val payment_c : List<String> = listOf("500 SR" , "600 SR" )
    val date_time_c : List<String> = listOf("10 / 21 / 2021 , 03 : 30 PM"  )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cancelledOrderBinding = FragmentCancelledOrderBinding.inflate(inflater , container , false)

        val recyclerView = cancelledOrderBinding.cancelledRecyclerview
        recyclerView.adapter = cancalled_order_adapter(provider_name_c , Payment_Method_c , service_name_c , payment_c , date_time_c , order_number_c)
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false
        )
        return cancelledOrderBinding.root
    }


}