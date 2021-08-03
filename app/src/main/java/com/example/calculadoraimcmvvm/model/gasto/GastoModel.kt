package com.example.calculadoraimcmvvm.model.gasto

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId

open class GastoModel: RealmObject() {

    @PrimaryKey
    var id: String = ObjectId().toString()
    var distanciaModel: Float = 0.0f
    var precoModel: Float = 0.0f
    var autonomiaModel: Float = 0.0f
    var resultadoModel: Float = 0.0f

}