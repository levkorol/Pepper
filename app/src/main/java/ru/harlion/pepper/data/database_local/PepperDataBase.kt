package ru.harlion.pepper.data.database_local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.harlion.pepper.data.database_local.dao.EmotionEventDao
import ru.harlion.pepper.models.EmotionEvent

@Database(entities = [EmotionEvent::class], version = 1, exportSchema = false)
@TypeConverters(PepperTypeConverters::class)
abstract class PepperDataBase : RoomDatabase() {
    abstract fun emoEventDao(): EmotionEventDao
}

//val migration_1_2 = object : Migration(1, 2) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL(
//            "ALTER TABLE EmotionEvent ADD COLUMN suspect TEXT NOT NULL DEFAULT ''"
//        )
//    }
//}