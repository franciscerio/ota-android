package com.fcerio.ota.android.presentation.ui.components.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fcerio.ota.android.R
import com.fcerio.ota.android.presentation.ui.theme.white

@Composable
fun CircleCheck(modifier: Modifier, size: Int = 50) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_check),
            contentDescription = "",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .size(size.dp)
                .background(MaterialTheme.colorScheme.primary, CircleShape)
                .border(color = white, width = 3.dp, shape = CircleShape)
                .clip(CircleShape)
        )
    }
}