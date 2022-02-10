package ru.harlion.pepper.models.exercise

class LifeBalance(
    val livingSphere: List<LivingSphere>
)

class LivingSphere(
     val id : Long,
     val name: String,
     val score: Int
)
