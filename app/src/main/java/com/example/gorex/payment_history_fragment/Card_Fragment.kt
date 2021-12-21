package com.example.gorex.payment_history_fragment

import com.example.gorex.Adapters.Card_fragment_Adapter
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.activity.Add_Activity
import com.example.gorex.R
import com.example.gorex.databinding.FragmentCardBinding


class Card_Fragment : Fragment() {
   lateinit var cardBinding: FragmentCardBinding

   var card_logo : List<Int> = listOf(R.drawable.visa_car , R.drawable.visa_car , R.drawable.visa_car )
    var card_number : List<String> = listOf("2556" , "4567" )
    var card_holder_name : List<String> = listOf("Adnan Akhtar" , "Maliha Ashfeen" )
    var expiry_date : List<String> = listOf("02/2021" , "12/2024" )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cardBinding = FragmentCardBinding.inflate(inflater , container , false)
        cardBinding.cardPlus.setOnClickListener{
            requireActivity().run {
                startActivity(Intent(this, Add_Activity::class.java))
                finish()
                overridePendingTransition(0, 0)
            }
        }
        val recyclerView = cardBinding.cardFragmentRecyclerview
        recyclerView.adapter = Card_fragment_Adapter(card_logo , card_holder_name ,expiry_date)
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)

        return cardBinding.root
    }


}