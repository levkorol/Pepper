package ru.harlion.pepper.ui.adding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.harlion.pepper.AppActivity
import ru.harlion.pepper.R
import ru.harlion.pepper.base.BindingFragment
import ru.harlion.pepper.databinding.FragmentAddEmotionEventBinding


class AddEmotionEventFragment :
    BindingFragment<FragmentAddEmotionEventBinding>(FragmentAddEmotionEventBinding::inflate) {

    override fun onStart() {
        super.onStart()
        (activity as AppActivity).setBottomNavigationVisible(false)
    }

    override fun onStop() {
        super.onStop()
        (activity as AppActivity).setBottomNavigationVisible(true)
    }

    companion object {
        fun newInstance(id: Long) = AddStressFragment().apply {
            arguments = Bundle().apply {
                putLong("id_emotion_event", id)
            }
        }
    }
}