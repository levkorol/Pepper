package ru.harlion.pepper.data

import android.content.Context
import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.room.Room
import ru.harlion.pepper.R
import ru.harlion.pepper.data.database_local.PepperDataBase
import ru.harlion.pepper.models.Emotion
import ru.harlion.pepper.models.EmotionEvent
import java.util.concurrent.Executors


private const val DATABASE_NAME = "pepper-database"

class Repository private constructor(context: Context){

    private val database: PepperDataBase = Room.databaseBuilder(
        context.applicationContext,
        PepperDataBase::class.java,
        DATABASE_NAME
    ).build()

    private val emoEventDao = database.emoEventDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun addEventEmotion(emotionEvent: EmotionEvent) {
        executor.execute {
            emoEventDao.addEmotionEvent(emotionEvent)
        }
    }

    fun updateEventEmotion(emotionEvent: EmotionEvent) {
        executor.execute {
            emoEventDao.updateEmotionEvent(emotionEvent)
        }
    }

    fun getListEmotionEvents() : LiveData<List<EmotionEvent>> = emoEventDao.getEmotionEvents()

    fun getDetailEmotionEvent(id: Long) : LiveData<EmotionEvent?> = emoEventDao.getEmotionEvent(id)

    companion object {

        private var INSTANCE: Repository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = Repository(context)
            }
        }

        fun get(): Repository {
            return INSTANCE ?: throw IllegalStateException("Repository must be init")
        }

        //tests
        fun getListEmotionEvent(): List<EmotionEvent> {
            return listOf(
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event neme meme",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        ), Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            Color.BLUE,
                            false
                        ), Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.t_dark,
                            false
                        ), Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.t_dark,
                            false
                        ), Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.t_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.t_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event name event name event name event name event name event name event ",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.t_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event neme meme",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_light,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event name event name event name event name event name event name event ",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event neme meme",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event name event name event name event name event name event name event ",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event neme meme",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
                EmotionEvent(
                    1,
                    System.currentTimeMillis(),
                    " people",
                    " place",
                    "name event name event name event name event name event name event name event ",
                    "description",
                    listOf(
                        Emotion(
                            1,
                            "name emo",
                            "category",
                            10,
                            R.color.blue_dark,
                            false
                        )
                    ),
                    "label"

                ),
            )
        }
    }
}