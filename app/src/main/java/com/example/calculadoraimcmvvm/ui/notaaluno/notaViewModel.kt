package com.example.calculadoraimcmvvm.ui.notaaluno

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculadoraimcmvvm.model.nota.notaModel
import com.example.calculadoraimcmvvm.repo.dp.nota.Repository as AlunoDB

class notaViewModel: ViewModel() {

    private val _alunos = MutableLiveData<ArrayList<notaModel>>().apply { value = ArrayList() }
    val alunos: LiveData<ArrayList<notaModel>> = _alunos

    fun criaAluno(aluno: notaModel){
        AlunoDB().create(aluno)
    }

    fun getAllAlunos(){
        AlunoDB().getAll(_alunos)
    }


}