package com.notally.extended.activities

import android.view.inputmethod.InputMethodManager
import com.notally.extended.miscellaneous.setOnNextAction
import com.notally.extended.recyclerview.ListItemListener
import com.notally.extended.recyclerview.adapter.MakeListAdapter
import com.notally.extended.recyclerview.viewholder.MakeListVH
import com.notally.extended.room.ListItem
import com.notally.extended.room.Type

class MakeList : NotallyActivity(Type.LIST) {

    private lateinit var adapter: MakeListAdapter

    override fun configureUI() {
        binding.EnterTitle.setOnNextAction {
            moveToNext(-1)
        }

        if (model.isNewNote) {
            if (model.items.isEmpty()) {
                addListItem()
            }
        }
    }


    override fun setupListeners() {
        super.setupListeners()
        binding.AddItem.setOnClickListener {
            addListItem()
        }
    }

    override fun setStateFromModel() {
        super.setStateFromModel()
        val elevation = resources.displayMetrics.density * 2

        adapter = MakeListAdapter(model.textSize, elevation, model.items, object : ListItemListener {

            override fun delete(position: Int) {
                model.items.removeAt(position)
                adapter.notifyItemRemoved(position)
            }

            override fun moveToNext(position: Int) {
                this@MakeList.moveToNext(position)
            }

            override fun textChanged(position: Int, text: String) {
                model.items[position].body = text
            }

            override fun checkedChanged(position: Int, checked: Boolean) {
                model.items[position].checked = checked
            }
        })

        binding.RecyclerView.adapter = adapter
    }


    private fun addListItem() {
        val position = model.items.size
        val listItem = ListItem(String(), false)
        model.items.add(listItem)
        adapter.notifyItemInserted(position)
        val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        binding.RecyclerView.post {
            val viewHolder = binding.RecyclerView.findViewHolderForAdapterPosition(position) as MakeListVH?
            if (viewHolder != null) {
                viewHolder.binding.EditText.requestFocus()
                inputManager.showSoftInput(viewHolder.binding.EditText, InputMethodManager.SHOW_IMPLICIT)
            }
        }
    }

    private fun moveToNext(currentPosition: Int) {
        val viewHolder = binding.RecyclerView.findViewHolderForAdapterPosition(currentPosition + 1) as MakeListVH?
        if (viewHolder != null) {
            if (viewHolder.binding.CheckBox.isChecked) {
                moveToNext(currentPosition + 1)
            } else viewHolder.binding.EditText.requestFocus()
        } else addListItem()
    }
}
