package com.example.calculadoraimcmvvm.model.nota

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId

open class notaModel: RealmObject() {

    @PrimaryKey
    var id: String = ObjectId().toString()
    var nomeAluno: String = ""
    var ava1: Float = 0.0f
    var ava2: Float = 0.0f
    var media: Float = 0.0f
}
