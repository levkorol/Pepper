package ru.harlion.pepper.ui.adding

import androidx.lifecycle.ViewModel
import ru.harlion.pepper.data.Repository
import ru.harlion.pepper.models.Emotion
import ru.harlion.pepper.models.EmotionEvent

class AddEmotionEventViewModel : ViewModel() {

    private val repository = Repository.get()

    fun addEventRepository(
        date: Long,
        name: String,
        emotions: List<Emotion>,
    ) {
        val eventEmotion = EmotionEvent(
            date = date,
            name = name,
            emotion = emotions
        )
        repository.addEventEmotion(eventEmotion)
    }

    fun updateRepository() {

    }
}