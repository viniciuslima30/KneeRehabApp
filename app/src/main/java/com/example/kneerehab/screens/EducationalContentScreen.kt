
package com.example.kneerehab.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kneerehab.data.api.Post
import com.example.kneerehab.data.api.RetrofitClient

@Composable
fun EducationalContentScreen(
    onBackClick: () -> Unit
) {

    var posts by remember {
        mutableStateOf<List<Post>>(emptyList())
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    var errorMessage by remember {
        mutableStateOf<String?>(null)
    }

    // Faz a requisição quando a tela é aberta
    LaunchedEffect(Unit) {

        try {
            posts = RetrofitClient.api.getPosts()
        } catch (e: Exception) {
            errorMessage = "Não foi possível carregar os conteúdos."
        } finally {
            isLoading = false
        }
    }

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
            text = "Conteúdos educativos",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        when {

            isLoading -> {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            errorMessage != null -> {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(errorMessage!!)
                }
            }

            else -> {

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(posts) { post ->

                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {

                                Text(
                                    text = post.title,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = post.body,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
