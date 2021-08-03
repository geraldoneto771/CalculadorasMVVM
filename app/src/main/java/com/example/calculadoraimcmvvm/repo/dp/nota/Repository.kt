package com.example.calculadoraimcmvvm.repo.dp.nota

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.calculadoraimcmvvm.model.nota.notaModel
import io.realm.Realm
import io.realm.kotlin.where

class Repository {
    fun create(aluno: notaModel) {
        val realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            it.insert(aluno)
        }
    }

    fun getAll(_alunos: MutableLiveData<ArrayList<notaModel>>) {
        val realm = Realm.getDefaultInstance()

            val alunos = realm.where<notaModel>().findAll()

            val list = ArrayList<notaModel>()
            list.addAll(alunos)

            _alunos.value = list
            Log.e("Result", list.toString())
    }

}