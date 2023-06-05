package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.customColorsPalette

@Composable
fun Url(url: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(shape = CircleShape),
        backgroundColor = MaterialTheme.customColorsPalette.urlContainer
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = url,
                modifier = Modifier
                    .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 10.dp)
                    .width(0.dp)
                    .weight(1f),
                style = MaterialTheme.typography.body2
            )

            IconButton(onClick = { onClick() }, modifier = Modifier.padding(end = 10.dp)) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_copy),
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = stringResource(R.string.text_copy_link),
                    modifier = Modifier
                        .size(40.dp)
                        .padding(10.dp)

                )
            }
        }
    }
}
