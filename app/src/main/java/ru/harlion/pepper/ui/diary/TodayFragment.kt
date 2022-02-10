package ru.harlion.pepper.ui.diary

import android.os.Bundle
import android.view.View
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import ru.harlion.pepper.base.BindingFragment
import ru.harlion.pepper.data.Repository
import ru.harlion.pepper.databinding.FragmentTodayBinding
import ru.harlion.pepper.ui.adding.AddEmotionEventFragment
import ru.harlion.pepper.ui.diary.adapter.AdapterEmotionSEvent
import ru.harlion.pepper.util.replaceFragment


class TodayFragment : BindingFragment<FragmentTodayBinding>(FragmentTodayBinding::inflate) {

    private lateinit var adapterEmotionEvents: AdapterEmotionSEvent

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecViewEmotionsEvents()
    }

    private fun initRecViewEmotionsEvents() {
        val recyclerView = binding.todayRecyclerView
        val llm = FlexboxLayoutManager(requireContext(), FlexDirection.ROW, FlexWrap.WRAP)
        llm.alignItems = AlignItems.FLEX_START
        adapterEmotionEvents = AdapterEmotionSEvent {
            requireParentFragment().replaceFragment(
                AddEmotionEventFragment.newInstance(it),
                true
            )
        }
        recyclerView.layoutManager = llm
        recyclerView.adapter = adapterEmotionEvents


        val listEmotionEvent = Repository.getListEmotionEvent()
        if (listEmotionEvent.isNotEmpty()) {
            adapterEmotionEvents.items = listEmotionEvent
            binding.emptyListTodayTv.visibility = View.GONE
        } else {
            binding.emptyListTodayTv.visibility = View.VISIBLE
        }

    }
}