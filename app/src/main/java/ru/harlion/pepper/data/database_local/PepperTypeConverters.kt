package ru.harlion.pepper.data.database_local

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import ru.harlion.pepper.PepperApp
import ru.harlion.pepper.models.Emotion

object PepperTypeConverters {

    @TypeConverter
    fun emotionToString(emotion : List<Emotion>): String = PepperApp.gson.toJson(emotion)

    @TypeConverter
    fun stringToEmotion(string: String): List<Emotion> =
        PepperApp.gson.fromJson(string, TypeToken.getParameterized(List::class.java, Emotion::class.java).type)
}