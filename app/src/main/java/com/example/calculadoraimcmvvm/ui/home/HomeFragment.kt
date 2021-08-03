package com.example.calculadoraimcmvvm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.calculadoraimcmvvm.R
import com.example.calculadoraimcmvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.bttImc.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeToImcFragment2()
            findNavController().navigate(action)
        }
        binding.bttGastoViagem.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeToGastoViagem()
            findNavController().navigate(action)
        }
        binding.bttNotaAluno.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeToNotaDoAluno()
            findNavController().navigate(action)
        }
        binding.bttListaAluno.setOnClickListener{
           findNavController().navigate(HomeFragmentDirections.actionHomeToListaAluno())
        }
        return binding.root
    }
}