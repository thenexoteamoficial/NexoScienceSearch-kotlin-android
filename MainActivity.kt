package com.thenexoteam.nexoscience

// =============================================
// NEXOSCIENCESEARCH - Buscador de Artículos Científicos
// Versión Profesional Mejorada
// =============================================

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                NexoScienceSearchApp()
            }
        }
    }
}

@Composable
fun NexoScienceSearchApp() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedArticle by remember { mutableStateOf<Article?>(null) }

    val articles = listOf(
        Article("Machine Learning Applications in Climate Modeling", "Dr. Elena Vargas", "2025", "Inteligencia Artificial", "Este estudio explora cómo los modelos de machine learning pueden mejorar las predicciones climáticas a largo plazo."),
        Article("Quantum Algorithms for Optimization Problems", "Prof. Marco Ruiz", "2024", "Computación Cuántica", "Se presentan nuevos algoritmos cuánticos diseñados para resolver problemas de optimización complejos."),
        Article("Advances in Solid-State Battery Technology", "Dr. Sofia Patel", "2025", "Energía", "Investigación sobre baterías de estado sólido con mayor densidad energética y seguridad."),
        Article("Deep Learning for Early Disease Detection", "Dr. Carlos Mendoza", "2024", "Medicina", "Uso de redes neuronales profundas para la detección temprana de enfermedades mediante imágenes médicas."),
        Article("AI-Driven Sustainable Agriculture Systems", "Dra. Laura Kim", "2025", "Agricultura", "Sistemas inteligentes basados en IA para optimizar el uso de recursos en la agricultura."),
    )

    val filteredArticles = if (searchQuery.isBlank()) articles else articles.filter {
        it.title.contains(searchQuery, ignoreCase = true) ||
        it.author.contains(searchQuery, ignoreCase = true) ||
        it.topic.contains(searchQuery, ignoreCase = true)
    }

    if (selectedArticle != null) {
        // Pantalla de detalle del artículo
        ArticleDetailScreen(
            article = selectedArticle!!,
            onBack = { selectedArticle = null }
        )
    } else {
        // Pantalla principal de búsqueda
        SearchScreen(
            searchQuery = searchQuery,
            onSearchChange = { searchQuery = it },
            articles = filteredArticles,
            onArticleClick = { selectedArticle = it }
        )
    }
}

@Composable
fun SearchScreen(
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    articles: List<Article>,
    onArticleClick: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "NexoScienceSearch",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Explora artículos científicos de calidad",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchChange,
            label = { Text("Buscar por título, autor o tema") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (articles.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("No se encontraron resultados", style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(articles) { article ->
                    ArticleCard(
                        article = article,
                        onClick = { onArticleClick(article) }
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleCard(article: Article, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(article.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(6.dp))
            Text("${article.author} • ${article.year}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            AssistChip(onClick = {}, label = { Text(article.topic) })
        }
    }
}

@Composable
fun ArticleDetailScreen(article: Article, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del Artículo") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize()
        ) {
            Text(article.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(12.dp))
            Text("${article.author} • ${article.year} • ${article.topic}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(24.dp))
            Text(article.abstract, style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(40.dp))

            Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
                Text("Volver a la búsqueda")
            }
        }
    }
}

data class Article(
    val title: String,
    val author: String,
    val year: String,
    val topic: String,
    val abstract: String
)