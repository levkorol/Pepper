package ru.harlion.pepper.models.exercise

class DreamDiary (
    val id: Long,
    val name: Long,
    val date: Long,
    val isDone: Boolean,
    val isTopical: Boolean,
    val position: Int,
    val deadline: Long,
    val steps: List<String>
)