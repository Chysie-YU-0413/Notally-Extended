package com.notally.extended.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.notally.extended.room.Label
import com.notally.extended.room.NotallyDatabase

class LabelModel(app: Application) : AndroidViewModel(app) {

    private val database = NotallyDatabase.getDatabase(app)
    private val labelDao = database.getLabelDao()
    val labels = labelDao.getAll()

    fun insertLabel(label: Label, onComplete: (success: Boolean) -> Unit) =
        executeAsyncWithCallback({ labelDao.insert(label) }, onComplete)
}
