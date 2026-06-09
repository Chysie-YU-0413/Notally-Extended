package com.notally.extended.fragments

import android.view.Menu
import android.view.MenuInflater
import androidx.navigation.fragment.findNavController
import com.notally.extended.R
import com.notally.extended.miscellaneous.add

class Notes : NotallyFragment() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.add(R.string.search, R.drawable.search) { findNavController().navigate(R.id.NotesToSearch) }
    }


    override fun getObservable() = model.baseNotes

    override fun getBackground() = R.drawable.notebook
}
