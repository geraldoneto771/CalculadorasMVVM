package com.example.calculadoraimcmvvm.ui.notaaluno

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.calculadoraimcmvvm.databinding.FragmentNotaDoAlunoBinding
import com.example.calculadoraimcmvvm.model.nota.notaModel
import com.google.android.material.snackbar.Snackbar
import java.lang.NumberFormatException

class NotaDoAluno : Fragment() {
        private lateinit var binding: FragmentNotaDoAlunoBinding
        private lateinit var viewModel: notaViewModel

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {

            binding = FragmentNotaDoAlunoBinding.inflate(layoutInflater)
            viewModel = ViewModelProvider(requireActivity()).get(notaViewModel::class.java)
            binding.bttSair.setOnClickListener{
                findNavController().popBackStack()
            }

            binding.bttCalcular.setOnClickListener{
                calcularGasto()
            }

            return binding.root
        }

        private fun calcularGasto() {
            if(validaCalcularOK()) {
                try {
                   val nome = binding.editNome.text.toString()
                    val av1 = binding.editAva1.text.toString().toFloat()
                    val av2 = binding.editAva2.text.toString().toFloat()

                    val totalNota: Float = (av1 + av2) / 2

                    val aluno = notaModel()

                    aluno.ava1 = av1
                    aluno.ava2 = av2
                    aluno.media = totalNota
                    aluno.nomeAluno = nome

                    viewModel.criaAluno(aluno)
                    Snackbar.make(
                        binding.root,
                        "Adicionado com sucesso", Snackbar.LENGTH_SHORT
                    ).show()
                    findNavController().popBackStack()

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

        private fun validaCalcularOK(): Boolean {
            return (binding.editNome.text.toString() != ""
                    && binding.editAva1.text.toString() != ""
                    && binding.editAva2.text.toString() != "")

        }
    }