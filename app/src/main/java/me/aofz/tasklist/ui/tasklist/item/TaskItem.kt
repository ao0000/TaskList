package me.aofz.tasklist.ui.tasklist.item

import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import com.xwray.groupie.viewbinding.BindableItem
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.ListItemBinding
import me.aofz.tasklist.model.Task

class TaskItem(val task: Task) :
    BindableItem<ListItemBinding>(task.id.hashCode().toLong()) {

    override fun initializeViewBinding(view: View): ListItemBinding = ListItemBinding.bind(view)

    override fun getLayout(): Int = R.layout.list_item

    override fun bind(viewBinding: ListItemBinding, position: Int) {
        viewBinding.listTitleText.text = task.title
        viewBinding.listDescriptionText.text = task.description
    }

    override fun getSwipeDirs(): Int = ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT

}