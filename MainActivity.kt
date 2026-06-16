package com.thenexoteam.nexoscience

// =============================================
// NEXOSCIENCESEARCH - Buscador de Artículos Científicos
// Desarrollado por THE NEXO TEAM
// Elevado a nivel profesional
// =============================================

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Actividad principal de NexoScienceSearch.
 * Maneja la UI completa usando Jetpack Compose + Material 3.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                NexoScienceSearchScreen()
            }
        }
    }
}

@Composable
fun NexoScienceSearchScreen() {
    var searchQuery by remember { mutableStateOf("") }

    // Datos de ejemplo (en el futuro se pueden reemplazar por datos reales de una API)
    val articles = listOf(
        Article("Machine Learning Applications in Climate Modeling", "Dr. Elena Vargas", "2025", "Inteligencia Artificial"),
        Article("Quantum Algorithms for Optimization Problems", "Prof. Marco Ruiz", "2024", "Computación Cuántica"),
        Article("Advances in Solid-State Battery Technology", "Dr. Sofia Patel", "2025", "Energía"),
        Article("Deep Learning for Early Disease Detection", "Dr. Carlos Mendoza", "2024", "Medicina"),
        Article("AI-Driven Sustainable Agriculture Systems", "Dra. Laura Kim", "2025", "Agricultura"),
        Article("Natural Language Processing in Scientific Literature", "Dr. Ahmed Hassan", "2024", "Inteligencia Artificial")
    )

    // Filtrado en tiempo real
    val filteredArticles = if (searchQuery.isBlank()) {
        articles
    } else {
        articles.filter {
            it.title.contains(searchQuery, ignoreCase = true) ||
            it.author.contains(searchQuery, ignoreCase = true) ||
            it.topic.contains(searchQuery, ignoreCase = true)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título
        Text(
            text = "NexoScienceSearch",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Buscador de artículos científicos",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Barra de búsqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar artículos, autores o temas...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de resultados
        if (filteredArticles.isEmpty()) {
            // Estado vacío
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text(
                    text = "No se encontraron resultados",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredArticles) { article ->
                    ArticleCard(article = article)
                }
            }
        }
    }
}

@Composable
fun ArticleCard(article: Article) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${article.author} • ${article.year}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            AssistChip(
                onClick = { },
                label = { Text(article.topic) }
            )
        }
    }
}

data class Article(
    val title: String,
    val author: String,
    val year: String,
    val topic: String
)