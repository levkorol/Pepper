package ru.harlion.pepper.models.exercise

class ScaredDiary (
    val id : Long,
    val data: Long,
    val descriptionScared: String,
    val trial: List<String>,//переживание
    val profit: List<String>, //выгоды если преодолеть этот страх
    val costInaction: List<String> //цена бездействия
        )