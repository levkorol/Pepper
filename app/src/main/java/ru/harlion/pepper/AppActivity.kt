package ru.harlion.pepper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.harlion.pepper.ui.adding.AddEmotionEventFragment
import ru.harlion.pepper.ui.adding.AddStressFragment
import ru.harlion.pepper.ui.diary.MainFragment
import ru.harlion.pepper.ui.emotion.EmotionFragment
import ru.harlion.pepper.ui.info_exercises.InformationFragment
import ru.harlion.pepper.ui.info_exercises.menu_exercise.life_balance.LifeBalanceFragment
import ru.harlion.pepper.ui.profile.ProfileFragment
import ru.harlion.pepper.ui.statistic.StatisticFragment
import ru.harlion.pepper.util.Prefs
import ru.harlion.pepper.util.replaceFragment

class AppActivity : AppCompatActivity() {

    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var fab1: FloatingActionButton
    private lateinit var fab2: FloatingActionButton
    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var prefs: Prefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPrefs()

        bottomNavView = findViewById(R.id.bottom_nav_view)
        floatingActionButton = findViewById(R.id.fab_add_button)
        bottomAppBar = findViewById(R.id.bottomAppBar)
        fab1 = findViewById(R.id.fab_1)
        fab2 = findViewById(R.id.fab_2)

        bottomNavView.background = null

        replaceFragment(MainFragment(), false)

        floatingActionButton.setOnClickListener {
            if(fab1.visibility != View.VISIBLE) {
                fab1.visibility = View.VISIBLE
                fab2.visibility = View.VISIBLE
                floatingActionButton.setImageResource(R.drawable.ic_baseline_close_24)
            } else {
                fab1.visibility = View.GONE
                fab2.visibility = View.GONE
                floatingActionButton.setImageResource(R.drawable.ic_baseline_add_24)
            }
        }

        fab1.setOnClickListener {
            fab1.visibility = View.GONE
            fab2.visibility = View.GONE
            replaceFragment(AddEmotionEventFragment(), true)
        }

        fab2.setOnClickListener {
            fab1.visibility = View.GONE
            fab2.visibility = View.GONE
            replaceFragment(LifeBalanceFragment(), true)
        }

        bottomNavView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_main_page -> {
                    replaceFragment(MainFragment(), true)
                    true
                }
                R.id.item_emotion_page -> {
                    replaceFragment(StatisticFragment(), true)
                    true
                }
                R.id.item_profile_page -> {
                    replaceFragment(ProfileFragment(), true)
                    true
                }
                R.id.item_information_page -> {
                    replaceFragment(InformationFragment(), true)
                    true
                }
                else -> false
            }
        }
    }

    private fun initPrefs() {
        prefs = Prefs(this)
        if(prefs.isShowOnBoarding) {
            //todo
        } else {

        }
        when(prefs.theme) {
            Prefs.THEME_AQUAMARINE -> {
                //todo
            }
            Prefs.THEME_RUBIN -> {

            }
            Prefs.THEME_NEPHRITE -> {

            }
            Prefs.THEME_GRAY -> {

            }
        }
    }

    fun setBottomNavigationVisible(isVisible: Boolean) {
        bottomNavView.isVisible = isVisible
        floatingActionButton.isVisible = isVisible
        bottomAppBar.isVisible = isVisible
        if(!isVisible) {
            fab1.isVisible = false
            fab2.isVisible = false
        }
    }

    fun updateNavigation(fragment: Fragment) {
        when (fragment) {
            is MainFragment -> bottomNavView.menu.findItem(
                R.id.item_main_page
            ).isChecked =
                true
            is EmotionFragment -> bottomNavView.menu.findItem(
                R.id.item_emotion_page
            ).isChecked =
                true
            is InformationFragment -> bottomNavView.menu.findItem(
                R.id.item_information_page
            ).isChecked =
                true
            is ProfileFragment -> bottomNavView.menu.findItem(
                R.id.item_profile_page
            ).isChecked =
                true
        }
    }
}