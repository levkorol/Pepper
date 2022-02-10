package ru.harlion.pepper.ui.info_exercises


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ru.harlion.pepper.AppActivity
import ru.harlion.pepper.base.BindingFragment
import ru.harlion.pepper.databinding.FragmentInformationBinding
import ru.harlion.pepper.ui.info_exercises.menu_exercise.ItemMenuInfoExercise
import ru.harlion.pepper.ui.info_exercises.menu_exercise.MenuExerciseAdapter


class InformationFragment :
    BindingFragment<FragmentInformationBinding>(FragmentInformationBinding::inflate) {

    private lateinit var adapterMenu: MenuExerciseAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViewMenu()
    }

    private fun initRecyclerViewMenu() {
        val llm = GridLayoutManager(requireContext(), 2)
        llm.orientation = GridLayoutManager.VERTICAL
        adapterMenu = MenuExerciseAdapter()
        binding.infoExerciseMenuRecyclerView.apply {
            layoutManager = llm
            adapter = adapterMenu
        }

        adapterMenu.item = menuItems()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppActivity).updateNavigation(InformationFragment())
    }

    private fun menuItems(): List<ItemMenuInfoExercise> {
        return listOf(
            ItemMenuInfoExercise(
                1,
                "Дневник благодарностей",
                String(Character.toChars(0x1F9D8)),
                true,
                "1",
                1
            ),
            ItemMenuInfoExercise(
                1,
                "Дневник желаний",
                String(Character.toChars(0x1F9DE)),
                true,
                "1",
                1
            ),
            ItemMenuInfoExercise(
                1,
                "Дневник страхов и действий",
                String(Character.toChars(0x1F9DB)),
                true,
                "1",
                1
            ),
            ItemMenuInfoExercise(
                1,
                "Дневник убеждений",
                String(Character.toChars(0x1F645)),
                true,
                "1",
                1
            ),
            ItemMenuInfoExercise(
                1,
                "Уничтожте негатив",
                String(Character.toChars(0x1F608)),
                false,
                "Простое и эффективное упражнение",
                1
            ),
            ItemMenuInfoExercise(
                1,
                "Колесо жизненного баланса",
                String(Character.toChars(0x1F9DA)),
                false,
                "",
                1
            ),
        )
    }
}