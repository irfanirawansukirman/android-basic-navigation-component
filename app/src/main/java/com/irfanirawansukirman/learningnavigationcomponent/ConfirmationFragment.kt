package com.irfanirawansukirman.learningnavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_confirmation.*
import java.math.BigDecimal

class ConfirmationFragment : Fragment() {

    private var navController: NavController? = null
    private var recipient: String? = null
    private var money: Money? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            recipient = getString("recipient")
            money = getParcelable("amount")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val amount = money?.amount ?: BigDecimal(0)
        val confirmationMessage = "You have send $amount to $recipient"
        confirmation_message.text = confirmationMessage
    }
}