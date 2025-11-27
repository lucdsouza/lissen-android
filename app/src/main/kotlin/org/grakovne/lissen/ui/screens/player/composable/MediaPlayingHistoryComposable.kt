package org.grakovne.lissen.ui.screens.player.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.grakovne.lissen.lib.domain.ListeningHistoryItem
import org.grakovne.lissen.ui.extensions.formatTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListeningHistoryComposable(
  onItemSelected: (ListeningHistoryItem) -> Unit,
  onDismissRequest: () -> Unit,
) {
  ModalBottomSheet(
    containerColor = colorScheme.background,
    onDismissRequest = onDismissRequest,
    content = {
      Column(
        modifier =
          Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Text(
          text = "Playing history",
          style = typography.bodyLarge,
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
          itemsIndexed(HistoryStubItems) { index, item ->
            ListItem(
              headlineContent = {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  verticalAlignment = Alignment.CenterVertically,
                ) {
                  Text(
                    text = item.title,
                    style = typography.bodyMedium,
                    modifier = Modifier.weight(1f),
                  )

                  Text(
                    text = item.position.formatTime(),
                    style = typography.bodyMedium,
                  )
                }
              },
              modifier =
                Modifier
                  .fillMaxWidth()
                  .clickable {
                    onItemSelected(item)
                    onDismissRequest()
                  },
            )

            if (index < HistoryStubItems.size - 1) {
              HorizontalDivider()
            }
          }
        }
      }
    },
  )
}

private val HistoryStubItems =
  listOf(
    ListeningHistoryItem("Глава 1", 9100),
    ListeningHistoryItem("Глава 2", 9120),
    ListeningHistoryItem("Глава 3", 10000),
    ListeningHistoryItem("Глава 4", 10500),
  )
