
package com.example.kneerehab.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.kneerehab.data.database.FavoriteDao

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    favoriteDao: FavoriteDao,
    onFavoriteClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {

    val favorites by favoriteDao
        .getAllFavorites()
        .collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Meus Favoritos")
                },
                navigationIcon = {
                    TextButton(onClick = onBackClick) {
                        Text("Voltar")
                    }
                }
            )
        }
    ) { padding ->

        if (favorites.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("Você ainda não possui favoritos.")
            }

        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp),
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
