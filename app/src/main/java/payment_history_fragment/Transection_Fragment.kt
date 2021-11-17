package payment_history_fragment

import Adapters.transection_fragment_Adapter
import android.app.AlertDialog
import android.app.Notification
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gorex.R
import com.example.gorex.databinding.FragmentTransectionBinding


class Transection_Fragment : Fragment() {


    lateinit var transectionBinding: FragmentTransectionBinding

    val order_number_transection : List<String> = listOf("3433455", "3433445" , "3433456" , "5343455", "3433455", "3433445" , "3433456" , "5343455")
    val order_payment_transection : List<String> = listOf("20.40" , "30.56" , "34.00" , "100","20.40" , "30.56" , "34.00" , "100")
    val date_time_transection : List<String> = listOf("01:02 AM" , "07:17 AM" , "11:47 AM" , "09:37 AM" , "01:02 AM" , "07:17 AM" , "11:47 AM" , "09:37 AM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       transectionBinding = FragmentTransectionBinding.inflate(inflater , container , false)
        val recyclerView  = transectionBinding.transectionRecyclerView
        recyclerView.adapter = transection_fragment_Adapter(order_number_transection ,order_payment_transection , date_time_transection)
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)


        transectionBinding.filterImage.setOnClickListener{
           showcustomdialuge()
        }

        return transectionBinding.root
    }

  private  fun showcustomdialuge(){

        val dialogview = layoutInflater.inflate(R.layout.filter_dialuge_box  , null )
        val customdialog = AlertDialog.Builder(context).setView(dialogview).show()
      customdialog.window?.setBackgroundDrawable(resources.getDrawable(R.drawable.dialuge_box_bg))


        val button_apply_filter = dialogview.findViewById<Button>(R.id.apply_button)
        button_apply_filter.setOnClickListener{
            customdialog.dismiss()
        }


    }
}



