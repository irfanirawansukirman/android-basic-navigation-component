package com.irfanirawansukirman.learningnavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import kotlinx.android.synthetic.main.fragment_specify_amount.view.*
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment() {

    private var navController: NavController? = null
    private var recipient: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        send_btn.setOnClickListener {
            val amount = Money(BigDecimal(input_amount.text.toString()))
            val bundle = bundleOf(
                "recipient" to recipient,
                "amount" to amount
            )
            navController?.navigate(
                R.id.action_specifyAmountFragment_to_confirmationFragment,
                bundle
            )
        }
        cancel_btn.setOnClickListener { requireActivity().onBackPressed() }

        val message = "Sending money to $recipient"
        view.recipient.text = message
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }
}