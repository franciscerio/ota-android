package com.fcerio.ota.android.presentation.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fcerio.ota.android.R
import com.fcerio.ota.android.presentation.ui.components.progress.CustomProgressBar
import com.fcerio.ota.android.presentation.ui.theme.black
import com.fcerio.ota.android.utils.parse

@Composable
fun ComponentTopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .padding(horizontal = 16.dp)
                .requiredHeight(60.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            var counter by remember { mutableIntStateOf(0) }

            Image(
                painter = painterResource(id = R.drawable.journey_icon),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(50.dp)
            )

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxHeight()
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                var currentProgress by remember { mutableIntStateOf(50) }

                Text(
                    modifier = Modifier.wrapContentWidth(),
                    text = stringResource(R.string.taming_temper),
                    style = MaterialTheme.typography.titleMedium,
                    // Will use MaterialTheme for this one
                    color = Color.parse("#212121")
                )

                Row(
                    modifier = Modifier
                        .wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomProgressBar(
                        modifier = Modifier
                            .requiredHeight(4.dp)
                            .requiredWidth(72.dp),
                        indicatorNumber = currentProgress,
                        indicatorPadding = 0.dp,
                    )
                    Text(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(horizontal = 8.dp),
                        text = "3%",
                        style = MaterialTheme.typography.bodyMedium,
                        // Will use MaterialTheme for this one
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_fire),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(32.dp)
                )
                Text(
                    modifier = Modifier.wrapContentWidth(),
                    text = counter.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    // Will use MaterialTheme for this one
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_avatar),
                contentDescription = "",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(50.dp)
                    .shadow(2.dp, CircleShape, false)
                    .background(Color.White, CircleShape)
                    .border(color = black.copy(alpha = 0.08f), width = 1.dp, shape = CircleShape)
                    .clip(CircleShape)
            )
        }
    }
}