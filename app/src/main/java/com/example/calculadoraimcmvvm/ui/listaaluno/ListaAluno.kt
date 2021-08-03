package com.example.calculadoraimcmvvm.ui.listaaluno

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculadoraimcmvvm.R
import com.example.calculadoraimcmvvm.databinding.ItemAlunoUI
import com.example.calculadoraimcmvvm.databinding.ListAlunoUI
import com.example.calculadoraimcmvvm.model.nota.notaModel
import com.example.calculadoraimcmvvm.ui.notaaluno.notaViewModel

class ListaAluno : Fragment() {
    private lateinit var bind: ListAlunoUI
    private lateinit var viewModel: notaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = ListAlunoUI.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity()).get(notaViewModel::class.java)

        viewModel.getAllAlunos()
        viewModel.alunos.observe(viewLifecycleOwner, Observer {
            bind.recyclerview.adapter = AlunoAdapter(it)
            bind.recyclerview.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        })

        return bind.root
    }

    class AlunoAdapter(val lista: ArrayList<notaModel>) : RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>(){
       inner class AlunoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            var binding : ItemAlunoUI?
                    init {
                        binding = ItemAlunoUI.bind(itemView)
                    }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
            return AlunoViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.res_item_aluno, parent, false)

            )
        }

        override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
            val aluno = lista[position]
            holder.binding?.nomeText?.text = aluno.nomeAluno

            if(aluno.media < 5){
                holder.binding?.resultadoText?.text = "Reprovado"
            } else {
                holder?.binding?.resultadoText?.text = "Aprovado"

            }

        }

        override fun getItemCount(): Int {
            return lista.size
        }

    }

}