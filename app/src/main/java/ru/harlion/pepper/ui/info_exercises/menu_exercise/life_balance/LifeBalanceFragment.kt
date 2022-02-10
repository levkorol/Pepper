package ru.harlion.pepper.ui.info_exercises.menu_exercise.life_balance

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import ru.harlion.pepper.base.BindingFragment
import ru.harlion.pepper.databinding.FragmentLifeBalanceBinding


class LifeBalanceFragment :
    BindingFragment<FragmentLifeBalanceBinding>(FragmentLifeBalanceBinding::inflate) {
    var radarData: RadarData? = null
    private lateinit var radarDataSet: RadarDataSet
    var radarEntries = mutableListOf<RadarEntry>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#4DD0E1"))
        colors.add(Color.parseColor("#FFF176"))
        colors.add(Color.parseColor("#FF8A65"))
        colors.add(Color.parseColor("#4DD0E1"))
        colors.add(Color.parseColor("#FFF176"))
        colors.add(Color.parseColor("#FF8A65"))

        getEntries()
        radarDataSet = RadarDataSet(radarEntries, "")
        radarData = RadarData(radarDataSet)
        binding.radarChart.data = radarData
        radarDataSet.colors = colors
        radarDataSet.valueTextColor = Color.BLACK
        radarDataSet.valueTextSize = 0f


//        binding.radarChart.colo
//            .apply {
//
//        }
    }


    private fun getEntries() {

        radarEntries.add(RadarEntry(0f, 0.21f))
        radarEntries.add(RadarEntry(1f, 0.12f))
        radarEntries.add(RadarEntry(2f, 0.20f))
        radarEntries.add(RadarEntry(3f, 0.52f))
        radarEntries.add(RadarEntry(4f, 0.29f))
        radarEntries.add(RadarEntry(5f, 0.62f))
        radarEntries.add(RadarEntry(6f, 0.52f))
        radarEntries.add(RadarEntry(7f, 0.29f))
        radarEntries.add(RadarEntry(8f, 0.62f))
        radarEntries.add(RadarEntry(9f, 0.62f))
        radarEntries.add(RadarEntry(10f, 0.62f))
    }
}