package ru.harlion.pepper.ui.info_exercises.menu_exercise

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.harlion.pepper.base.BindingHolder
import ru.harlion.pepper.databinding.ItemMenuInfoExerciseBinding


private typealias ItemHolderMenu = BindingHolder<ItemMenuInfoExerciseBinding>

class MenuExerciseAdapter() : RecyclerView.Adapter<ItemHolderMenu>() {

    var item: List<ItemMenuInfoExercise> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemHolderMenu(ItemMenuInfoExerciseBinding::inflate, parent).apply {

        }

    override fun onBindViewHolder(holder: ItemHolderMenu, position: Int) {
        holder.binding.apply {
            itemNameMenu.text = item[position].name
            itemPickTv.text = item[position].image
            itemCountWriting.text =
                if (item[position].isCount) "${item[position].writing} записей" else "${item[position].writing}"
        }
    }

    override fun getItemCount() = item.size

}

class ItemMenuInfoExercise(
    val id: Long,
    val name: String,
    val image: String,
    val isCount: Boolean,
    val writing: String,
    val background: Int
)
