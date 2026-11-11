
package com.example.kneerehab.screens

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.kneerehab.data.UserPreferences
import com.example.kneerehab.data.notifications.ReminderScheduler
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    onExploreClick: () -> Unit,
    onFavoritesClick: () -> Unit,
    onEducationalClick: () -> Unit,
    userPreferences: UserPreferences
) {

    val context = LocalContext.current

    val remindersEnabled by userPreferences.remindersEnabled
        .collectAsState(initial = false)

    val coroutineScope = rememberCoroutineScope()

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->

        if (granted) {
            coroutineScope.launch {
                userPreferences.setRemindersEnabled(true)
            }

            ReminderScheduler.schedule(context)
        }
    }

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
                onClick = onExploreClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Explorar lesões")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onFavoritesClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Meus Favoritos")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onEducationalClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Conteúdos educativos")
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

                Text("Receber lembretes")

                Spacer(modifier = Modifier.width(8.dp))

                Switch(
                    checked = remindersEnabled,
                    onCheckedChange = { enabled ->

                        if (enabled) {

                            if (
                                Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                                ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.POST_NOTIFICATIONS
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {
                                permissionLauncher.launch(
                                    Manifest.permission.POST_NOTIFICATIONS
                                )
                            } else {

                                coroutineScope.launch {
                                    userPreferences.setRemindersEnabled(true)
                                }

                                ReminderScheduler.schedule(context)
                            }

                        } else {

                            coroutineScope.launch {
                                userPreferences.setRemindersEnabled(false)
                            }

                            ReminderScheduler.cancel(context)
                        }
                    }
                )
            }
        }
    }
}
