
package com.example.kneerehab.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kneerehab.data.Exercise

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExercisesScreen(
    injuryName: String,
    exercises: List<Exercise>,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Exercícios")
                },
                navigationIcon = {
                    TextButton(onClick = onBackClick) {
                        Text("Voltar")
                    }
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Text(
                    text = "Relacionados a: $injuryName",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            items(exercises) { exercise ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = exercise.name,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = exercise.description)
                    }
                }
            }
        }
    }
}
