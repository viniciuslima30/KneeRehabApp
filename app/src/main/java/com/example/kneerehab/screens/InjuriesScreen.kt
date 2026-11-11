
package com.example.kneerehab.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kneerehab.data.injuries

@Composable
fun InjuriesScreen(
    onInjuryClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        TextButton(
            onClick = onBackClick,
            contentPadding = PaddingValues(0.dp)
        ) {
            Text("← Voltar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Lesões do joelho",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(injuries) { injury ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onInjuryClick(injury.id)
                        }
                ) {

                    Text(
                        text = injury.name,
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }
}
