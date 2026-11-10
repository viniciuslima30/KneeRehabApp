
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InjuriesScreen(
    onInjuryClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Lesões do joelho")
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
