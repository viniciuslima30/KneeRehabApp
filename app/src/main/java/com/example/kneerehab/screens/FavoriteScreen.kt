
package com.example.kneerehab.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kneerehab.data.database.FavoriteDao

@Composable
fun FavoritesScreen(
    favoriteDao: FavoriteDao,
    onFavoriteClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {

    val favorites by favoriteDao
        .getAllFavorites()
        .collectAsState(initial = emptyList())

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
            text = "Meus Favoritos",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (favorites.isEmpty()) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Você ainda não possui favoritos.")
            }

        } else {

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(favorites) { favorite ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onFavoriteClick(favorite.injuryId)
                            }
                    ) {

                        Text(
                            text = favorite.injuryName,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}
