package ru.harlion.pepper.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EmotionEvent(
    @PrimaryKey(autoGenerate = true) val id: Long = -1,
    val date: Long = 0,
    val people: String = "",
    val place: String = "",
    val name: String = "", //название
    val description: String= "", //описание
    val emotion: List<Emotion> = listOf(), // емоции чувства ощущения
    val label: String = ""

)

class Emotion(
    val id: Long,
    val name: String, //описание
    val category: String,
    val level: Int, //max 10
    val color: Int,
    val isFav: Boolean
)