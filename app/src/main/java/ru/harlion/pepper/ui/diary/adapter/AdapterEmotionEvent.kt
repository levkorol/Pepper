package ru.harlion.pepper.ui.diary.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import ru.harlion.pepper.base.BindingHolder
import ru.harlion.pepper.databinding.ItemNoteEmotionBinding
import ru.harlion.pepper.models.Emotion
import ru.harlion.pepper.models.EmotionEvent

private typealias ItemHolderEmotionEvent = BindingHolder<ItemNoteEmotionBinding>
private typealias ItemHolder = BindingHolder<ItemNoteEmotionBinding>

class AdapterEmotionSEvent(
    private var adapterEmotion: AdapterEmotion? = null,
    private val clickListener: (Long) -> Unit,
) : RecyclerView.Adapter<BindingHolder<*>>() {

    var items: List<Any> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is EmotionEvent -> 1
            is EmotionEvent -> 2
            else -> throw Exception()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            1 -> {
                ItemHolderEmotionEvent(ItemNoteEmotionBinding::inflate, parent).apply {
                    binding.containerItemCardView.setOnClickListener {
                        if (bindingAdapterPosition > -1) {
                            clickListener.invoke((items[bindingAdapterPosition] as EmotionEvent).id)
                        }
                    }
                }
            }
            2 -> {
                TODO()
            }
            else -> throw Exception()
        }

    override fun onBindViewHolder(holder: BindingHolder<*>, position: Int) {
        when (holder.itemViewType) {
            1 -> {
                (holder.binding as ItemNoteEmotionBinding).apply {
                    val item = (items[position] as EmotionEvent)
                    emotionName.text = item.name
                    time.text = "19:00"//item[position].date
                    // containerItemCardView.setBackgroundColor(item[position].color)
                    emotionsRecyclerView.adapter
                    initRecyclerViewEmotion(emotionsRecyclerView, item.emotion)
                }
            }
            2 -> {
                TODO()
            }
            else -> throw Exception()
        }
    }

    override fun getItemCount() = items.size

    private fun initRecyclerViewEmotion(recyclerView: RecyclerView, emotions: List<Emotion>) {
        adapterEmotion = AdapterEmotion()
        val llm =  FlexboxLayoutManager(recyclerView.context, FlexDirection.ROW, FlexWrap.WRAP)

        llm.alignItems = AlignItems.FLEX_START

        recyclerView.layoutManager = llm
        recyclerView.adapter = adapterEmotion

        adapterEmotion?.item = emotions
    }

}