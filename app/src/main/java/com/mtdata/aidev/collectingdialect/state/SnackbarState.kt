package com.mtdata.aidev.collectingdialect.state

sealed interface SnackbarVisibleState {
    data object Hide : SnackbarVisibleState
    class Show(val msg: String): SnackbarVisibleState
}