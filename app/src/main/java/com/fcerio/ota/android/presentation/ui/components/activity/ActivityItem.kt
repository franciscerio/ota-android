package com.fcerio.ota.android.presentation.ui.components.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fcerio.ota.android.R
import com.fcerio.ota.android.utils.parse
import com.fcerio.ota.domain.Activity

@Composable
fun ActivityItem(
    item: Activity,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .wrapContentWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.lesson_image),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .wrapContentWidth()
                    .clip(RoundedCornerShape(24.dp))
            )

            CircleCheck(modifier = Modifier.align(Alignment.TopEnd), size = 40)
        }

        Text(
            text = item.title,
            modifier = Modifier
                .padding(top = 8.dp)
                .wrapContentWidth(),
            style = MaterialTheme.typography.titleLarge,
            // Will use MaterialTheme for this one
            color = Color.parse("#212121"),
            textAlign = TextAlign.Center
        )
    }
}