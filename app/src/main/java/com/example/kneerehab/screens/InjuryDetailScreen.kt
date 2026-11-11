
package com.example.kneerehab.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kneerehab.data.Injury
import com.example.kneerehab.data.database.Favorite
import com.example.kneerehab.data.database.FavoriteDao
import kotlinx.coroutines.launch

@Composable
fun InjuryDetailScreen(
    injury: Injury,
    favoriteDao: FavoriteDao,
    onBackClick: () -> Unit,
    onExercisesClick: () -> Unit
) {

    val isFavorite by favoriteDao
        .isFavorite(injury.id)
        .collectAsState(initial = false)

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        TextButton(
            onClick = onBackClick,
            contentPadding = PaddingValues(0.dp)
        ) {
            Text("← Voltar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Detalhes da lesão",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = injury.name,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Sobre a lesão",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = injury.description)

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Sintomas comuns",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        injury.symptoms.forEach { symptom ->

            Text(
                text = "• $symptom",
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onExercisesClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver exercícios relacionados")
        }

        Button(
            onClick = {
                coroutineScope.launch {

                    if (isFavorite) {
                        favoriteDao.removeFavorite(injury.id)
                    } else {
                        favoriteDao.addFavorite(
                            Favorite(
                                injuryId = injury.id,
                                injuryName = injury.name
                            )
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                if (isFavorite) {
                    "Remover dos favoritos"
                } else {
                    "Adicionar aos favoritos"
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Conteúdo educativo. Os sintomas podem variar e não substituem uma avaliação profissional."
        )
    }
}
