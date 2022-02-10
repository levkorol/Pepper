package ru.harlion.pepper.util

import android.content.Context

private const val PREFS_NAME = "prefs_name"
private const val ON_BOARDING_SHOW = "on_boarding_load"
private const val THEME = "theme"

class Prefs(val context: Context) {

    private val sharedPrefs =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    var isShowOnBoarding: Boolean
        get() = sharedPrefs.getBoolean(ON_BOARDING_SHOW, false)
        set(value) = sharedPrefs.edit().putBoolean(ON_BOARDING_SHOW, value)
            .apply()

    var theme: String
        get() = sharedPrefs.getString(THEME, "") ?: ""
        set(value) = sharedPrefs.edit().putString(THEME, value)
            .apply()

   companion object {
       const val THEME_AQUAMARINE = "theme_aquamarine"
       const val THEME_RUBIN = "theme_rubin"
       const val THEME_NEPHRITE = "theme_nephrite"
       const val THEME_GRAY = "theme_gray"
   }
}