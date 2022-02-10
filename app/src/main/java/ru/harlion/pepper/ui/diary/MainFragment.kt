package ru.harlion.pepper.ui.diary


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import ru.harlion.pepper.AppActivity
import ru.harlion.pepper.R
import ru.harlion.pepper.base.BindingFragment
import ru.harlion.pepper.databinding.FragmentMainBinding


class MainFragment : BindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainViewPager.adapter =
            ViewPagerFragmentStateAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabs, binding.mainViewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Сегодня"
//         ${String(Character.toChars(0x1F60C)
 //                   tab.setIcon(R.drawable.ic_baseline_wb_sunny_24)
                }
//                1 -> {
//                    tab.text = ""
//                    tab.setIcon(R.drawable.ic_post)
//                }
                else -> {
                    tab.text = "Месяц"
//  ${String(Character.toChars(0x1F9D8))
  //                  tab.setIcon(R.drawable.ic_baseline_calendar_today_24)
                }
            }

        }.attach()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppActivity).updateNavigation(MainFragment())
    }
}

class ViewPagerFragmentStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TodayFragment()
//            1 -> FavPostsFragment()
            else -> MonthFragment()
        }
    }

    override fun getItemCount(): Int = 2
}
