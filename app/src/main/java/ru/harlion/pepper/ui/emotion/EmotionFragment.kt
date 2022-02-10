package ru.harlion.pepper.ui.emotion


import ru.harlion.pepper.AppActivity
import ru.harlion.pepper.base.BindingFragment
import ru.harlion.pepper.databinding.FragmentEmotionBinding


class EmotionFragment : BindingFragment<FragmentEmotionBinding>(FragmentEmotionBinding::inflate) {

    override fun onResume() {
        super.onResume()
        (activity as AppActivity).updateNavigation(EmotionFragment())
    }
}