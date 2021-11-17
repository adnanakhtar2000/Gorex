package Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class Product_and_services_tab_Adapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm , BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var product_fragment_list : ArrayList<Fragment> = ArrayList()
    var product_title_list : ArrayList<String> = ArrayList()

    override fun getCount(): Int {
      return  product_fragment_list.size
    }

    override fun getItem(position: Int): Fragment {
        return product_fragment_list[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return product_title_list[position]
    }

    fun addfragments(fragment: Fragment , title : String){
        product_fragment_list.add(fragment)
        product_title_list.add(title)
    }
}