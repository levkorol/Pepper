package ru.harlion.pepper.models.exercise

data class Stress(
    val id: Long,
    val date: Long,
    val level: Int, //max 100
    val eventAffected: List<String>,//какое событие произошло
    val description: String, //описание что произошло и почему
    val emotion: String, // емоции чувства ощущения
    val solutionSituation: String, // как вы справились справляетесь ваше решение ситуации
    val solutionBest: String, // идеальный вариант решения именно ваших поступков
    val reallyReason: String, // Настоящая причина показать готовые
    val reallyReasonDescription: String, // Настоящая причина показать готовые описание
    val belief: String, // Убеждения которые привели к стрессу в данной ситуации
)


