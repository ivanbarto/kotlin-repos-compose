package com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.repositories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ivanbartolelli.kotlinreposcompose.R
import com.ivanbartolelli.kotlinreposcompose.features.repositories.domain.models.Repository
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables.ProfileImage
import com.ivanbartolelli.kotlinreposcompose.features.repositories.presentation.utils.composables.WatchersCounter

@Composable
fun RepositoryItem(repository: Repository, onClick : (repository : Repository) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(repository)
            }
            .padding(bottom = 10.dp)
            .padding(10.dp)
    ) {
        ProfileImage(repository.owner?.avatarUrl)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            Text(
                text = repository.name
                    ?: stringResource(R.string.text_no_name),
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )

            Text(
                text = stringResource(
                    id = R.string.text_by_user,
                    repository.owner?.userName
                        ?: stringResource(R.string.text_no_username)
                ), style = MaterialTheme.typography.body2
            )

            Row() {
                Spacer(
                    modifier = Modifier
                        .width(0.dp)
                        .weight(1f)
                )
                WatchersCounter(repository.watchersCount.toString())
            }

        }

    }
}
