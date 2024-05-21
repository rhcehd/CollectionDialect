package com.mtdata.aidev.collectingdialect.utils

class NavigateEvent(private val navigateResId: Int) {

    companion object {
        const val ID_NAVIGATE_UP = 0
    }
    private var hasBeenHandled = false

    fun getContentIfNotHandled(): Int? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            navigateResId
        }
    }

    fun peekContent(): Int = navigateResId
}