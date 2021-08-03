package com.example.calculadoraimcmvvm.ui.imc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.calculadoraimcmvvm.databinding.FragmentHomeBinding
import com.example.calculadoraimcmvvm.databinding.FragmentTelaImcBinding
import com.example.calculadoraimcmvvm.model.imc.ImcModel
import com.google.android.material.snackbar.Snackbar
import java.lang.NumberFormatException

class TelaImc : Fragment() {

    private lateinit var binding: FragmentTelaImcBinding
    private lateinit var viewModel: ImcViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTelaImcBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity()).get(ImcViewModel::class.java)

        binding.bttSair.setOnClickListener{
            findNavController().popBackStack()
        }

        viewModel.imcMV.observe(this.viewLifecycleOwner){ it: ImcModel ->

                if (it.totalModel < 18.5) {

                    binding.textImc.text = "IMC: ${"%.2f".format(it.totalModel)}"
                    binding.textResult.text = "Magreza"

                }

        }

        binding.bttCalcular.setOnClickListener{
            if(validaCalcularOK()) {
                try {

                        val peso = binding.editPeso.text.toString().toFloat()
                        val altura = binding.editAltura.text.toString().toFloat()

                        viewModel.soma(peso, altura)



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
        return (binding.editPeso.text.toString() != ""
                && binding.editAltura.text.toString() != "")
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////
                    //viewModel.updateImcData(peso.toString(), altura.toString(), totalImc.toString())
                    //val textimc =  viewModel?.imcmodel?.totalModel.toFloat()

                    /*else if(totalImc >= 18.5 && totalImc <= 24.9){
                        binding.textImc.text = "IMC: ${"%.2f".format(textimc)}"
                        binding.textResult.text = "Normal"
                    }
                    else if(totalImc >= 25.0 && totalImc <= 29.9){
                        binding.textImc.text = "IMC: ${"%.2f".format(textimc)}"
                        binding.textResult.text = "Sobrepeso"
                    }
                    else if(totalImc >= 30.0 && totalImc <= 39.9){
                        binding.textImc.text = "IMC: ${"%.2f".format(textimc)}"
                        binding.textResult.text = "Obesidade"
                    }
                    else{
                        binding.textImc.text = "IMC: ${"%.2f".format(textimc)}"
                        binding.textResult.text = "Obesidade grave"
                    }*/
////////////////////////////////////////////////////////////////////////////////////////////////////
