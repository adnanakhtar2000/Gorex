package com.example.gorex.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class Payment_Tab_Adapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm , BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

   var payment_fragment_list : ArrayList<Fragment> = ArrayList()
    var payment_title_list : ArrayList<String> = ArrayList()

    override fun getCount(): Int {
        return  payment_fragment_list.size
    }

    override fun getItem(position: Int): Fragment {
        return payment_fragment_list[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return payment_title_list[position]
    }

    fun  addfragments(fragment: Fragment , titles : String){
        payment_fragment_list.add(fragment)
        payment_title_list.add(titles)
    }
}