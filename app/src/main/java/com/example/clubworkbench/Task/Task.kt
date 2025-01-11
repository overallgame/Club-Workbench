package com.example.clubworkbench.Task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clubworkbench.databinding.TaskPageBinding

class Task: Fragment() {
    private var _binding: TaskPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TaskPageBinding.inflate(inflater,container,false)
        return binding.root
    }
}