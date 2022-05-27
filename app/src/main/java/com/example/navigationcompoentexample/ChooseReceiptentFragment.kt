package com.example.navigationcompoentexample

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import java.math.BigDecimal


class ChooseReceiptentFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_receiptent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.next_btn -> {
                val result=view?.findViewById<TextInputEditText>(R.id.input_recipient)?.text.toString()
                if(!TextUtils.isEmpty(result)){
                   val bundle= bundleOf("receipent" to result)
                    navController!!.navigate(R.id.action_chooseReceiptentFragment_to_specifyAmountFragment,bundle)
                }
                else{
                    Toast.makeText(context,"Please enter name",Toast.LENGTH_SHORT).show()
                }

            }
            R.id.cancel_btn -> activity?.onBackPressed()
        }

    }


}