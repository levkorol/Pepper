package ru.harlion.pepper.data.database_local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.harlion.pepper.models.EmotionEvent
import java.util.*

@Dao
interface EmotionEventDao {

    @Query("SELECT * FROM emotionEvent")
    fun getEmotionEvents(): LiveData<List<EmotionEvent>>

    @Query("SELECT * FROM emotionEvent WHERE id = (:id)")
    fun getEmotionEvent(id: Long): LiveData<EmotionEvent?>

    @Update
    fun updateEmotionEvent(emotionEvent: EmotionEvent)

    @Insert
    fun addEmotionEvent(emotionEvent: EmotionEvent)
}