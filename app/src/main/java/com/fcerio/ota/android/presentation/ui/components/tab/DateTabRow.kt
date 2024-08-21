package com.fcerio.ota.android.presentation.ui.components.tab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.fcerio.ota.android.R
import com.fcerio.ota.android.presentation.ui.theme.secondaryDefault

// Function to handle Object.
@ExperimentalFoundationApi
@Composable
fun DateTabRow(content: @Composable (Int) -> Unit) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val tabItem = listOf(
        TabItem(
            title = "MON"
        ), TabItem(
            title = "TUE"
        ), TabItem(
            title = "WED"
        ), TabItem(
            title = "THU"
        ), TabItem(
            title = "FRI"
        ), TabItem(
            title = "SAT"
        ), TabItem(
            title = "SUN"
        )
    )

    val pagerState = rememberPagerState {
        tabItem.size
    }

    LaunchedEffect(key1 = selectedTabIndex) {
        pagerState.scrollToPage(selectedTabIndex)
    }

    LaunchedEffect(key1 = pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress)
            selectedTabIndex = pagerState.currentPage
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItem.forEachIndexed { index, tabItem ->

                androidx.compose.material3.Tab(
                    modifier = Modifier.background(MaterialTheme.colorScheme.background),
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(
                            text = tabItem.title,
                            modifier = Modifier.wrapContentWidth(),
                            style = MaterialTheme.typography.titleSmall,
                            // Will use MaterialTheme for this one
                            color = if (index == selectedTabIndex) {
                                MaterialTheme.colorScheme.primary
                            } else secondaryDefault
                        )
                    },
                    icon = {
                        Icon(
                            painter = if (index == selectedTabIndex) {
                                painterResource(tabItem.selectedIcon)
                            } else painterResource(tabItem.unSelectedItem),
                            tint = if (index == selectedTabIndex) {
                                MaterialTheme.colorScheme.primary
                            } else secondaryDefault,
                            contentDescription = tabItem.title
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) { index ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                content(index)
            }
        }
    }
}

// Data Class to handle items
data class TabItem(
    val title: String,
    val unSelectedItem: Int = R.drawable.ic_unselected_circle,
    val selectedIcon: Int = R.drawable.ic_selected_circle
)