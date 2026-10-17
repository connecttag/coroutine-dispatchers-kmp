# ConnectTag Coroutine Dispatchers (KMP)

[![](https://jitpack.io/v/connecttag/coroutine-dispatchers-kmp.svg)](https://jitpack.io/#connecttag/coroutine-dispatchers-kmp)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A lightweight Kotlin Multiplatform library providing an injectable `DispatcherProvider` abstraction and platform-optimized implementations (`Android`, `JVM`, `iOS/Native`) to avoid hardcoded dispatchers and enable deterministic unit testing.

## Features

- 🌐 **Full Multiplatform Support**: Android, JVM, and Apple Native (iOS/macOS).
- 💉 **Dependency Injection Ready**: Easily inject `DispatcherProvider` interface into UseCases, Repositories, and ViewModels.
- 🧪 **Deterministic Unit Testing**: Includes `TestDispatcherProvider(testDispatcher)` to easily bind all coroutines to a test scheduler.
- 🚀 **Zero Overhead**: Direct delegation to platform-optimized `Dispatchers` at runtime.

## Installation

Add JitPack repository to your root `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = java.net.URI("https://jitpack.io") }
    }
}
```

Add the dependency to your common or platform `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.connecttag:coroutine-dispatchers-kmp:1.0.0")
}
```

## Quick Start

### 1. In Production Code

```kotlin
import org.connecttag.coroutine.DispatcherProvider
import org.connecttag.coroutine.DefaultDispatcherProvider

class GetUserUseCase(
    private val dispatcherProvider: DispatcherProvider = DefaultDispatcherProvider
) {
    suspend operator fun invoke(): User = withContext(dispatcherProvider.io) {
        // Fetch user from network/database
    }
}
```

### 2. In Unit Tests

```kotlin
import org.connecttag.coroutine.TestDispatcherProvider
import kotlinx.coroutines.test.StandardTestDispatcher

val testDispatcher = StandardTestDispatcher()
val useCase = GetUserUseCase(
    dispatcherProvider = TestDispatcherProvider(testDispatcher)
)
```

## License

```
Copyright 2026 Connect Tag

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
```
