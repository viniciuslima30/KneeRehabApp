# 🦵 KneeRehab

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose, com o objetivo de apresentar informações educativas sobre lesões do joelho e exercícios relacionados à reabilitação.

O projeto foi desenvolvido como atividade acadêmica, explorando recursos de desenvolvimento Android, persistência de dados e integração com APIs REST.

## 📱 Funcionalidades

- **Tela inicial:** apresentação do aplicativo e acesso às funcionalidades.
- **Catálogo de lesões:** informações sobre quatro lesões comuns do joelho.
- **Detalhes das lesões:** descrição e informações relacionadas a cada condição.
- **Exercícios:** catálogo com 16 exercícios, sendo quatro relacionados a cada lesão.
- **Vídeos demonstrativos:** acesso a pesquisas de demonstrações dos exercícios no YouTube.
- **Favoritos:** possibilidade de salvar e remover lesões favoritas.
- **Conteúdos educativos:** consumo de uma API REST externa para exibição de conteúdos.
- **Preferências:** armazenamento da configuração de recebimento de lembretes.
- **Notificações:** agendamento e exibição de lembretes locais.

## 🩺 Lesões disponíveis

O aplicativo apresenta informações sobre:

1. Tendinopatia patelar.
2. Condromalácia patelar.
3. Lesão do ligamento cruzado anterior (LCA).
4. Lesão de menisco.

## 🛠️ Tecnologias utilizadas

| Tecnologia | Aplicação |
|---|---|
| Kotlin | Linguagem de programação |
| Jetpack Compose | Construção das interfaces |
| Navigation Compose | Navegação entre telas |
| Room / SQLite | Persistência dos favoritos |
| DataStore | Armazenamento de preferências |
| Retrofit | Consumo de API REST |
| Gson | Conversão de dados JSON |
| WorkManager | Agendamento de notificações |
| Git / GitHub | Versionamento do projeto |

## 🌐 API REST

O aplicativo utiliza a API pública JSONPlaceholder para demonstrar a comunicação com um serviço externo.

A integração é realizada utilizando Retrofit e Gson, permitindo buscar conteúdos em formato JSON e exibi-los na tela de conteúdos educativos.

API utilizada: https://jsonplaceholder.typicode.com/

## 📂 Organização do projeto

```text
com.example.kneerehab/
│
├── MainActivity.kt
│
├── navigation/
│   └── AppNavigation.kt
│
├── screens/
│   ├── HomeScreen.kt
│   ├── InjuriesScreen.kt
│   ├── InjuryDetailScreen.kt
│   ├── ExercisesScreen.kt
│   ├── FavoritesScreen.kt
│   └── EducationalContentScreen.kt
│
├── data/
│   ├── Injury.kt
│   ├── Exercise.kt
│   ├── UserPreferences.kt
│   │
│   ├── api/
│   │   ├── Post.kt
│   │   ├── ApiService.kt
│   │   └── RetrofitClient.kt
│   │
│   ├── database/
│   │   ├── Favorite.kt
│   │   ├── FavoriteDao.kt
│   │   └── AppDatabase.kt
│   │
│   └── notifications/
│       ├── ReminderWorker.kt
│       └── ReminderScheduler.kt
│
└── ui/
    └── theme/
```

## ▶️ Como executar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/viniciuslima30/KneeRehabApp
```

2. Abra o projeto no Android Studio.

3. Aguarde a sincronização das dependências do Gradle.

4. Execute o aplicativo em um emulador ou dispositivo Android.

5. Permita o acesso às notificações quando solicitado, caso queira testar os lembretes.

**Requisitos:**
- Android Studio.
- JDK compatível com a configuração do projeto.
- Dispositivo ou emulador Android.
- Conexão com a internet para consumir a API e acessar o YouTube.

## 🚀 Possibilidades de evolução

- Integração com APIs especializadas em saúde e ortopedia.
- Inclusão de novos exercícios e lesões.
- Adição de conteúdos educativos atualizados.
- Melhorias na interface e experiência do usuário.

## ⚠️ Aviso importante

O KneeRehab possui finalidade exclusivamente educativa. As informações e os exercícios apresentados não substituem avaliação, diagnóstico ou orientação de profissionais de saúde.

## 👨‍💻 Autor

Desenvolvido como projeto acadêmico utilizando Kotlin e Jetpack Compose por Vinícius Lima Carneiro.