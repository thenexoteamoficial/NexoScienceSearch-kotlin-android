# 📚 NexoScienceSearch

**Buscador inteligente de artículos científicos para Android**

> Aplicación nativa en **Kotlin + Jetpack Compose** con estándares profesionales

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-blue?logo=kotlin)](https://kotlinlang.org)
[![Android](https://img.shields.io/badge/Android-API%2024+-green?logo=android)](https://developer.android.com)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1.6+-purple)](https://developer.android.com/jetpack/compose)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

## 📋 Tabla de Contenidos

- [Descripción](#-descripción)
- [Características](#-características)
- [Requisitos](#-requisitos)
- [Instalación](#-instalación)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Arquitectura](#-arquitectura)
- [Roadmap](#-roadmap)
- [Contribuciones](#-contribuciones)
- [Licencia](#-licencia)

## 🚀 Descripción

NexoScienceSearch es una aplicación moderna de búsqueda de artículos científicos diseñada para académicos, estudiantes e investigadores. Proporciona una interfaz limpia e intuitiva para explorar literatura científica con búsqueda avanzada y filtrado en tiempo real.

## ✨ Características

- 🔍 **Búsqueda en Tiempo Real** - Resultados instantáneos mientras escribes
- 🏷️ **Filtrado Múltiple** - Por título, autor, tema y año
- 🎨 **Interfaz Moderna** - Diseño Material 3 siguiendo estándares de Google
- 📱 **Responsive Design** - Optimizado para diferentes tamaños de pantalla
- ⚡ **Rendimiento Optimizado** - Composables eficientes y lazy loading
- 🧱 **Arquitectura Escalable** - Preparado para integración con APIs reales

## 🔧 Requisitos

- **Android Studio** 2023.1 o superior
- **Android SDK** API 24 (Android 7.0) o superior
- **Kotlin** 1.9+
- **Jetpack Compose** 1.6+
- Java 11 o superior

## 📥 Instalación

### Opción 1: Clonar y Compilar (Recomendado)

```bash
# Clonar el repositorio
git clone https://github.com/thenexoteamoficial/NexoScienceSearch-kotlin-android.git
cd NexoScienceSearch-kotlin-android

# Abrir en Android Studio
# File > Open > Selecciona la carpeta del proyecto
```

### Opción 2: Generar APK

```bash
# En Android Studio:
# Build > Build Bundle(s) / APK(s) > Build APK(s)

# O desde terminal (requiere gradle):
./gradlew assembleDebug
# APK generado en: app/build/outputs/apk/debug/app-debug.apk
```

### Opción 3: Instalación desde APK

1. Descarga el APK desde [Releases](../../releases)
2. Habilita "Instalar desde fuentes desconocidas" en tu dispositivo Android
3. Ejecuta el APK para instalar

## 📁 Estructura del Proyecto

```
NexoScienceSearch-kotlin-android/
├── MainActivity.kt              # Punto de entrada y composables principales
├── README.md                    # Este archivo
├── LICENSE                      # Licencia MIT
└── .gitignore                  # Configuración de Git
```

### Componentes Principales

#### `MainActivity.kt`

- **NexoScienceSearchApp()** - Composable raíz con gestión de estado
- **SearchScreen()** - Pantalla principal de búsqueda
- **ArticleCard()** - Componente para mostrar artículos
- **ArticleDetailScreen()** - Vista detallada del artículo
- **Article** - Data class para modelar artículos científicos

## 🏗️ Arquitectura

```
┌─────────────────────────────┐
│   NexoScienceSearchApp      │ (State Management)
├─────────────────────────────┤
│   SearchScreen              │ (Lista de artículos)
│   ArticleDetailScreen       │ (Detalle del artículo)
├─────────────────────────────┤
│   UI Components             │ (Cards, Text, etc.)
├─────────────────────────────┤
│   Article Model             │ (Data class)
└─────────────────────────────┘
```

**Patrón:** State Hoisting + Composable Hierarchy

**Stack Tecnológico:**
- Jetpack Compose (UI declarativa)
- Material Design 3
- Kotlin Coroutines (preparado)
- LiveData/StateFlow (preparado)

## 🎯 Roadmap

- [x] ✅ Búsqueda funcional básica
- [x] ✅ Filtrado por título, autor y tema
- [x] ✅ Interfaz Material 3
- [x] ✅ Pantalla de detalle del artículo
- [ ] 🔄 Integración con APIs reales (Semantic Scholar, CrossRef, PubMed)
- [ ] 🔄 Filtros avanzados (año, revista, h-index del autor)
- [ ] 🔄 Sistema de favoritos con Room Database
- [ ] 🔄 Guardado local y modo offline
- [ ] 🔄 Soporte multi-idioma
- [ ] 🔄 Dark mode automático
- [ ] 🔄 Optimización para tablets

## 🧪 Testing

Próximamente se agregará:
- Unit Tests (JUnit + Mockito)
- UI Tests (Compose Testing)
- Cobertura mínima del 70%

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Para contribuir:

1. Fork el repositorio
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

Por favor, asegúrate de seguir las convenciones de código Kotlin y Material Design.

## 📖 Documentación de Código

El código incluye comentarios explicativos en:
- Headers de funciones principales
- Lógica compleja
- Configuraciones especiales

Para generar documentación Kotlin Doc:

```bash
./gradlew dokka
```

## 🐛 Reporte de Bugs

Si encuentras un bug, por favor:

1. Verifica que no exista un issue similar
2. Abre un nuevo issue con:
   - Descripción clara del problema
   - Pasos para reproducirlo
   - Versión de Android
   - Logs si están disponibles

## 📞 Contacto

**THE NEXO TEAM S.A. de C.V**  
Creadores de innovaciones tecnológicas

- 🌐 [Sitio Web](https://thenexoteam.com)
- 📧 Email: info@thenexoteam.com
- 🐙 GitHub: [@thenexoteamoficial](https://github.com/thenexoteamoficial)

## 📄 Licencia

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE) - Ver el archivo [LICENSE](LICENSE) para más detalles.

---

<div align="center">

**Hecho con ❤️ por THE NEXO TEAM**

⭐ Si te gusta este proyecto, ¡no olvides dejar una estrella! ⭐

</div>
