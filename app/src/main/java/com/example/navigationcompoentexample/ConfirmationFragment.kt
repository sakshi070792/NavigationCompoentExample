package com.example.navigationcompoentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ConfirmationFragment : Fragment() {
    lateinit var receiptent:String
    lateinit var amount:String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        receiptent= arguments?.getString("receipent")!!
        amount=arguments?.getString("amount")!!

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val confMessage="You have sent $amount to $receiptent"
        view.findViewById<TextView>(R.id.confirmation_message).text=confMessage
    }


}