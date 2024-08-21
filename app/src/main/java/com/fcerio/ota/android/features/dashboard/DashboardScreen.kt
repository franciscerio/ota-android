package com.fcerio.ota.android.features.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fcerio.ota.android.presentation.ui.components.ComponentTopBar
import com.fcerio.ota.android.presentation.ui.components.activity.ActivityItem
import com.fcerio.ota.android.presentation.ui.components.activity.ActivityLevel
import com.fcerio.ota.android.presentation.ui.components.tab.DateTabRow
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardScreen(
    state: DashboardContract.State,
    effectFlow: Flow<DashboardContract.Effect>?,
    onEventSent: (event: DashboardContract.Event) -> Unit,
    onNavigationRequested: (DashboardContract.Effect.Navigation) -> Unit
) {
    Scaffold(
        topBar = {
            ComponentTopBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                // scaffold padding
                .padding(innerPadding)
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            DateTabRow {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(
                        start = 12.dp,
                        top = 16.dp,
                        end = 12.dp,
                        bottom = 16.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    state.levels.forEachIndexed { _, level ->
                        item(span = { GridItemSpan(2) }) {
                            ActivityLevel(
                                level
                            )
                        }

                        level.activities.forEachIndexed { index, value ->
                            item(span = { GridItemSpan(if (index == level.activities.size - 1 && index % 2 == 0) 2 else 1) }) {
                                ActivityItem(
                                    value
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}