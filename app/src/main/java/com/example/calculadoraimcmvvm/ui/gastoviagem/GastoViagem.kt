package com.example.calculadoraimcmvvm.ui.gastoviagem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.calculadoraimcmvvm.databinding.FragmentGastoViagemBinding
import com.example.calculadoraimcmvvm.databinding.FragmentTelaImcBinding
import com.example.calculadoraimcmvvm.model.gasto.GastoModel
import com.example.calculadoraimcmvvm.ui.imc.ImcViewModel
import com.google.android.material.snackbar.Snackbar
import java.lang.NumberFormatException


class GastoViagem : Fragment() {
    private lateinit var binding: FragmentGastoViagemBinding
    private lateinit var viewmodel: GastoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGastoViagemBinding.inflate(layoutInflater)
        viewmodel = ViewModelProvider(requireActivity()).get(GastoViewModel::class.java)
        binding.bttSair.setOnClickListener{
            binding.textTotalValue.text = viewmodel.clear().toString()
            findNavController().popBackStack()
        }

        viewmodel.gastoMV.observe(this.viewLifecycleOwner){ it: GastoModel ->

            binding.textTotalValue.text = it.resultadoModel.toString()

        }

        binding.bttCalcular.setOnClickListener{
            if(validaCalcularOK()) {
                try {

                    val distancia = binding.editDistance.text.toString().toFloat()
                    val preco = binding.editPrice.text.toString().toFloat()
                    val autonomia = binding.editAutonomy.text.toString().toFloat()
                    viewmodel.CalculaGasto(distancia, preco, autonomia)


                }catch (nfe: NumberFormatException) {
                    Snackbar.make(
                        binding.root,
                        "Informe valores validos", Snackbar.LENGTH_SHORT
                    ).show()
                }
            }else {
                Snackbar.make(
                    binding.root,
                    "Preencha todos os campos", Snackbar.LENGTH_SHORT
                ).show()
            }
        }
        return binding.root
    }

    private fun validaCalcularOK(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString() != "0")

    }
}