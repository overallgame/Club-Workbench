package com.example.clubworkbench.Account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clubworkbench.databinding.AccountPageBinding

class Account: Fragment() {
    private var _binding: AccountPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AccountPageBinding.inflate(inflater,container,false)
        return binding.root
    }
}