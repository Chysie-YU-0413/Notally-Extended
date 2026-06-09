package com.notally.extended.preferences

import com.notally.extended.R

sealed interface TextInfo {

    val title: Int

    val key: String
    val defaultValue: String
}

object AutoBackup : TextInfo {
    const val emptyPath = "emptyPath"

    override val title = R.string.auto_backup

    override val key = "autoBackup"
    override val defaultValue = emptyPath
}
