package ru.harlion.pepper.ui.profile

import ru.harlion.pepper.AppActivity
import ru.harlion.pepper.base.BindingFragment
import ru.harlion.pepper.databinding.FragmentProfileBinding


class ProfileFragment : BindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override fun onResume() {
        super.onResume()
        (activity as AppActivity).updateNavigation(ProfileFragment())
    }
}