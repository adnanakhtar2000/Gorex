package Adapters

import androidx.fragment.app.*
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT

class Tab_Page_Adapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm , BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var fragmentlist : ArrayList<Fragment> = ArrayList()
    var fragmenttitle : ArrayList<String> = ArrayList()
    override fun getCount(): Int {
        return fragmentlist.size
    }

    override fun getItem(position: Int): Fragment {
       return fragmentlist[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmenttitle[position]
    }
fun addfragment(fragment: Fragment , title : String){
    fragmentlist.add(fragment)
    fragmenttitle.add(title)
}

}