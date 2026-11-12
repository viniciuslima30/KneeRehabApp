
package com.example.kneerehab.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kneerehab.data.api.NewsArticle
import com.example.kneerehab.data.api.RetrofitClient

@Composable
fun EducationalContentScreen(
    onBackClick: () -> Unit
) {

    val context = LocalContext.current

    var news by remember {
        mutableStateOf<List<NewsArticle>>(emptyList())
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    var errorMessage by remember {
        mutableStateOf<String?>(null)
    }

    LaunchedEffect(Unit) {
        try {
            val response = RetrofitClient.api.getNews(
                query = "\"joelho\" OR \"tendinopatia patelar\" OR \"ligamento cruzado\"",
                apiKey = RetrofitClient.API_KEY
            )

            news = response.articles

        } catch (e: Exception) {
            errorMessage = "Não foi possível carregar as notícias."
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
            text = "Notícias sobre joelho",
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

            news.isEmpty() -> {
                Text("Nenhuma notícia encontrada.")
            }

            else -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(news) { article ->

                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {

                                Text(
                                    text = article.title,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = article.description
                                        ?: "Descrição indisponível."
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Fonte: ${article.source.name}",
                                    style = MaterialTheme.typography.bodySmall
                                )

                                Text(
                                    text = "Publicado em: ${article.publishedAt.take(10)}",
                                    style = MaterialTheme.typography.bodySmall
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Button(
                                    onClick = {
                                        val intent = Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse(article.url)
                                        )
                                        context.startActivity(intent)
                                    },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Ler notícia completa")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
