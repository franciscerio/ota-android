package com.fcerio.ota.android.presentation.ui.components.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.fcerio.ota.android.R
import com.fcerio.ota.android.presentation.ui.theme.black
import com.fcerio.ota.android.utils.parse
import com.fcerio.ota.domain.Level

@Composable
fun ActivityLevel(item: Level) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .wrapContentWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.chapter_image),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(145.dp)
                    .padding(bottom = 8.dp)
            )

            Text(
                text = stringResource(id = R.string.level_format, item.level).uppercase(),
                modifier = Modifier
                    .wrapContentWidth()
                    .background(Color.parse("#212121"), RoundedCornerShape(12.dp))
                    .clip(RoundedCornerShape(12.dp))
                    .padding(top = 8.dp, start = 12.dp, bottom = 8.dp, end = 12.dp)
                    .align(Alignment.BottomCenter),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                textAlign = TextAlign.Center,

                )
        }

        Text(
            text = item.title,
            modifier = Modifier
                .padding(top = 12.dp)
                .wrapContentWidth(),
            style = MaterialTheme.typography.headlineLarge,
            // Will use MaterialTheme for this one
            color = Color.parse("#212121"),
            textAlign = TextAlign.Center
        )

        Text(
            text = item.description,
            modifier = Modifier
                .padding(top = 12.dp)
                .wrapContentWidth(),
            style = MaterialTheme.typography.titleSmall,
            // Will use MaterialTheme for this one
            color = Color.parse("#666666"),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}
