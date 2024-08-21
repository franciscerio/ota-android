package com.fcerio.ota.android.features.dashboard

import androidx.lifecycle.viewModelScope
import com.fcerio.ota.android.base.BaseViewModel
import com.fcerio.ota.data.features.level.LevelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: LevelRepository
) : BaseViewModel<DashboardContract.Event, DashboardContract.State, DashboardContract.Effect>() {

    init {
        loadLevels()
    }

    override fun setInitialState(): DashboardContract.State {
        return DashboardContract.State(
            levels = emptyList(),
            isLoading = false,
            isError = false
        )
    }

    override fun handleEvents(event: DashboardContract.Event) {
        when (event) {
            else -> {}
        }
    }

    private fun loadLevels() {
        viewModelScope.launch {
            repository.getLevels()
                .collectLatest { items ->
                    setState {
                        copy(levels = items)
                    }
                }
        }
    }
}