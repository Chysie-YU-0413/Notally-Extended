package com.notally.extended.fragments

import com.notally.extended.R

class Archived : NotallyFragment() {

    override fun getBackground() = R.drawable.archive

    override fun getObservable() = model.archivedNotes
}
