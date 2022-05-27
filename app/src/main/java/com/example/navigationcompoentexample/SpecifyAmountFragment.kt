package com.example.navigationcompoentexample

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment(),View.OnClickListener {

    var navController: NavController? = null
    lateinit var receiptent:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        receiptent= arguments?.getString("receipent")!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        val message="Sending money to $receiptent"
        view.findViewById<TextView>(R.id.recipient).text=message
    }

    override fun onClick(v: View?) {
        when(v!!.id){
           R.id.send_btn-> {
               val result= view?.findViewById<TextInputEditText>(R.id.input_amount)?.text.toString()
               if(!TextUtils.isEmpty(result)){
                   var bundle= bundleOf("receipent" to receiptent,"amount" to result)
                   navController?.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,bundle)
               }
               else{
                   Toast.makeText(context,"Enter amount",Toast.LENGTH_SHORT).show()
               }

           }
           R.id.cancel_btn-> activity?.onBackPressed()
        }

    }


}