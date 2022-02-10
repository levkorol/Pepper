package ru.harlion.pepper.ui.adding


import android.os.Bundle
import ru.harlion.pepper.AppActivity
import ru.harlion.pepper.base.BindingFragment
import ru.harlion.pepper.databinding.FragmentAddStressBinding


class AddStressFragment : BindingFragment<FragmentAddStressBinding>(FragmentAddStressBinding::inflate) {

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
                putLong("id_stress_event", id)
            }
        }
    }
}