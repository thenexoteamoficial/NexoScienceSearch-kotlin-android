package com.thenexoteam.nexoscience

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexoScienceSearchApp()
        }
    }
}

@Composable
fun NexoScienceSearchApp() {
    var searchText by remember { mutableStateOf("") }
    val articles = listOf(
        Article("Machine Learning in Climate Science", "Dr. Elena Vargas", "2025", "IA"),
        Article("Quantum Computing Applications", "Prof. Marco Ruiz", "2024", "Física"),
        Article("Advances in Renewable Energy", "Dr. Sofia Patel", "2025", "Energía"),
        Article("Neural Networks for Medical Diagnosis", "Dr. Carlos Mendoza", "2024", "Medicina"),
        Article("Sustainable Agriculture and AI", "Dra. Laura Kim", "2025", "Agricultura")
    )

    val filteredArticles = articles.filter {
        it.title.contains(searchText, ignoreCase = true) ||
        it.author.contains(searchText, ignoreCase = true)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("NexoScienceSearch", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Buscar artículos...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(filteredArticles) { article ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(article.title, style = MaterialTheme.typography.titleMedium)
                        Text("${article.author} • ${article.year} • ${article.topic}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

data class Article(val title: String, val author: String, val year: String, val topic: String)