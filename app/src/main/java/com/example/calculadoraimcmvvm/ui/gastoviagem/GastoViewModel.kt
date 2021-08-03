package com.example.calculadoraimcmvvm.ui.gastoviagem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculadoraimcmvvm.model.gasto.GastoModel

class GastoViewModel : ViewModel() {

    private val _gastoMV = MutableLiveData<GastoModel>().apply { value = GastoModel() }

    val gastoMV: LiveData<GastoModel> = _gastoMV

    fun CalculaGasto(distancia: Float, preco: Float, autonomia: Float){

        var total: Float = (distancia * preco) / autonomia

        _gastoMV.value = GastoModel().apply {
            distanciaModel = distancia
            precoModel = preco
            autonomiaModel = autonomia
            resultadoModel = total

        }

    }
    fun clear(){
        _gastoMV.value = GastoModel().apply {
            resultadoModel = 0.0f
        }
    }

}