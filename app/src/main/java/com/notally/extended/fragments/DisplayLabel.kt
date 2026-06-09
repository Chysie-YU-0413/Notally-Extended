package com.notally.extended.fragments

import androidx.lifecycle.LiveData
import com.notally.extended.R
import com.notally.extended.miscellaneous.Constants
import com.notally.extended.room.Item

class DisplayLabel : NotallyFragment() {

    override fun getBackground() = R.drawable.label

    override fun getObservable(): LiveData<List<Item>> {
        val label = requireNotNull(requireArguments().getString(Constants.SelectedLabel))
        return model.getNotesByLabel(label)
    }
}
