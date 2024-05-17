package com.mtdata.aidev.collectingdialect.utils

class NavigateEvent(private val navigateResId: Int) {

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