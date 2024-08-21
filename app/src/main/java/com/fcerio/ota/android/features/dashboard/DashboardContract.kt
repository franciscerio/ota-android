package com.fcerio.ota.android.features.dashboard

import com.fcerio.ota.android.base.ViewEvent
import com.fcerio.ota.android.base.ViewSideEffect
import com.fcerio.ota.android.base.ViewState
import com.fcerio.ota.domain.Level

class DashboardContract {
    sealed class Event : ViewEvent {
    }

    data class State(
        val levels: List<Level>,
        val isLoading: Boolean,
        val isError: Boolean,
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
        }
    }
}