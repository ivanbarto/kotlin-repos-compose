package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ivanbartolelli.kotlinreposcompose.R

@Composable
fun WatchersCounter(count : String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_eye),
            tint = MaterialTheme.colors.onBackground,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(text = count, Modifier.padding(start = 10.dp), style = MaterialTheme.typography.body2)
    }
}