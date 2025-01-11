package com.example.clubworkbench.Workbench

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clubworkbench.databinding.WorkbenchPageBinding

class Workbench: Fragment() {
    private var _binding: WorkbenchPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WorkbenchPageBinding.inflate(inflater,container,false)
        return binding.root
    }
}