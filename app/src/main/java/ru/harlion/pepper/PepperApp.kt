package ru.harlion.pepper

import android.app.Application
import com.google.gson.Gson
import ru.harlion.pepper.data.Repository

class PepperApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Repository.initialize(this)
    }

    companion object {
        val gson = Gson()
    }
}