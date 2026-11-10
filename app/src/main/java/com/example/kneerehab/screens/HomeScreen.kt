
package com.example.kneerehab.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kneerehab.data.UserPreferences
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    onExploreClick: () -> Unit,
    onFavoritesClick: () -> Unit,
    userPreferences: UserPreferences
) {

    val remindersEnabled by userPreferences.remindersEnabled
        .collectAsState(initial = false)

    val coroutineScope = rememberCoroutineScope()

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "KneeRehab",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Conheça as principais lesões do joelho e aprenda sobre exercícios relacionados à reabilitação.",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onExploreClick
            ) {
                Text("Explorar lesões")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onFavoritesClick
            ) {
                Text("Meus Favoritos")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Preferências",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Receber lembretes"
                )

                Spacer(modifier = Modifier.width(8.dp))

                Switch(
                    checked = remindersEnabled,
                    onCheckedChange = { enabled ->
                        coroutineScope.launch {
                            userPreferences.setRemindersEnabled(enabled)
                        }
                    }
                )
            }
        }
    }
}
