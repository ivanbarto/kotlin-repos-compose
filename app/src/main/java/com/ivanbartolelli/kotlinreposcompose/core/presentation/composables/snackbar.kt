package com.ivanbartolelli.kotlinreposcompose.core.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.core.presentation.theme.customColorsPalette

@Composable
fun MessageSnackbar(
    snackbarHostState: SnackbarHostState
) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { data ->
            TextSnackbar(data)
        },
        modifier = Modifier.clickable {
            snackbarHostState.currentSnackbarData?.dismiss()
        }
    )
}

@Composable
private fun TextSnackbar(data: SnackbarData) {
    Snackbar(
        modifier = Modifier.padding(8.dp),
        backgroundColor = MaterialTheme.customColorsPalette.snackbarContainer,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            if (data.actionLabel == SnackbarType.WARNING.ordinal.toString()) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_warning),
                    contentDescription = null,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
            Text(
                text = data.message,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}


enum class SnackbarType {
    INFO,
    WARNING,
}