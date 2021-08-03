package com.example.calculadoraimcmvvm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val conf = RealmConfiguration.Builder()
            .name("app.realm")
            .schemaVersion(0L)
            .allowQueriesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .build()

        Realm.setDefaultConfiguration(conf)
    }

}