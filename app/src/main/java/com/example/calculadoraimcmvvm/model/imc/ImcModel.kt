package com.example.calculadoraimcmvvm.model.imc

import io.realm.RealmObject
import org.bson.types.ObjectId

open class ImcModel (
    var pesoModel: Float = 0.0f,
    var alturaModel: Float = 0.0f,
    var totalModel: Float = 0.0f

): RealmObject()