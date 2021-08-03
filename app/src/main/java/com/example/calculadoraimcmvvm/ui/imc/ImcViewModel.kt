package com.example.calculadoraimcmvvm.ui.imc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculadoraimcmvvm.model.imc.ImcModel

class ImcViewModel: ViewModel() {

    private val _imcMV = MutableLiveData<ImcModel>().apply { value = ImcModel() }

    val imcMV: LiveData<ImcModel> = _imcMV

    fun soma(peso: Float, altura: Float){
        val total =  (peso / (altura * altura))

        _imcMV.value = ImcModel().apply {
            pesoModel = peso
            alturaModel = altura
            totalModel = total
        }
    }

}