Here's a lightweight Kotlin Android MVVM test app for abz.agency, tailored for Jetpack Compose apps, complete with Navigation, Retrofit, and Dagger-Hilt integration, so you can focus on your core features without getting bogged down in setup:

Key Features:

Fully Jetpack Compose integrated.
Seamless Jetpack Compose Navigation.
Retrofit setup with a functional sample API call.
Follows the MVVM architecture pattern.
Utilizes Kotlin DSL for clarity and conciseness.
Includes Chucker for easy network debugging.
Dependencies managed through Gradle Version Catalog.
Dependabot integration for automated dependency updates.
GitHub Actions for building APKs and uploading artifacts.
Glide for efficient image loading.
Getting Started:

Click on "Use this template" button to create a new repository.
Follow the provided TODOs to customize package names, server URLs, and API endpoints.
Enable Dependabot in repository settings for automated dependency updates.
Grant notification permission to the app for Chucker to function properly.
Project Structure:
The project follows a single-module architecture, organized into the following packages:

di: Contains Dagger-Hilt module configurations.
network: Houses API service definitions including endpoints and request types.
model: Contains data classes representing server responses.
repository: Defines repository interfaces and their implementations.
presentation: Handles the presentation layer of the app.