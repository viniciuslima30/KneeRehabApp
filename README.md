# KneeRehab 🦵

Aplicativo Android desenvolvido como projeto acadêmico utilizando Kotlin e Jetpack Compose. O objetivo é apresentar informações educativas sobre lesões do joelho, exercícios relacionados e notícias reais sobre saúde e reabilitação.

## 📱 Funcionalidades

- **Tela inicial:** acesso às funcionalidades do aplicativo.
- **Catálogo de lesões:** informações sobre quatro lesões do joelho:
    - Tendinopatia patelar;
    - Condromalácia patelar;
    - Lesão do ligamento cruzado anterior (LCA);
    - Lesão de menisco.
- **Detalhes das lesões:** descrição e sintomas comuns.
- **Exercícios:** catálogo com 16 exercícios educativos, quatro relacionados a cada lesão.
- **Vídeos demonstrativos:** links para pesquisas de demonstrações dos exercícios no YouTube.
- **Favoritos:** possibilidade de salvar e remover lesões favoritas.
- **Notícias:** integração com a GNews API para consultar notícias reais sobre joelho e reabilitação.
- **Preferências:** opção para ativar ou desativar lembretes.
- **Notificações:** envio de notificações locais utilizando WorkManager.

## 🛠️ Tecnologias utilizadas

- Kotlin
- Jetpack Compose
- Android Studio
- Navigation Compose
- Room / SQLite
- DataStore Preferences
- Retrofit
- Gson
- GNews API
- WorkManager

## 🗂️ Organização do projeto

```text
KneeRehab/
└── app/
    └── src/main/java/com/example/kneerehab/
        ├── MainActivity.kt
        ├── navigation/
        │   └── AppNavigation.kt
        ├── screens/
        │   ├── HomeScreen.kt
        │   ├── InjuriesScreen.kt
        │   ├── InjuryDetailScreen.kt
        │   ├── ExercisesScreen.kt
        │   ├── FavoritesScreen.kt
        │   └── EducationalContentScreen.kt
        └── data/
            ├── Injury.kt
            ├── Exercise.kt
            ├── UserPreferences.kt
            ├── api/
            ├── database/
            └── notifications/
```

## 🌐 API de notícias

O aplicativo utiliza a GNews API para buscar notícias relacionadas a joelho, tendinopatia patelar e lesões ligamentares.

A integração é realizada com Retrofit, que faz as requisições HTTP e converte as respostas JSON em objetos Kotlin.

Documentação: https://gnews.io/docs/v4

## 💾 Armazenamento de dados

- **Room / SQLite:** armazenamento local das lesões favoritas.
- **DataStore:** armazenamento da preferência de recebimento de lembretes.

## 🔔 Notificações

O WorkManager é utilizado para agendar notificações locais no dispositivo. O usuário pode ativar ou desativar os lembretes pela tela inicial.

## ▶️ Como executar

1. Clone o repositório.
2. Abra o projeto no Android Studio.
3. Aguarde a sincronização do Gradle.
4. Configure sua chave da GNews API em `RetrofitClient.kt`.
5. Execute o aplicativo em um emulador ou dispositivo Android.

### Configuração da API Key

No arquivo `RetrofitClient.kt`, substitua o valor de `API_KEY` pela sua chave:

```kotlin
const val API_KEY = "SUA_API_KEY"
```

**Importante:** não publique sua chave de API em repositórios públicos. Para uma aplicação de produção, utilize um backend para proteger essa credencial.

## ⚠️ Aviso

O KneeRehab possui finalidade exclusivamente educativa. As informações e os exercícios apresentados não substituem avaliação, diagnóstico ou orientação de um profissional de saúde.

## 👨‍💻 Autor

Desenvolvido como projeto acadêmico em Kotlin e Android Studio.