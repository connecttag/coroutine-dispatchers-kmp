plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmp.library)
    `maven-publish`
}

group = "org.connecttag.libs.kotlin"
version = "1.0.0"

kotlin {
    android {
        namespace = "org.connecttag.coroutine"
        compileSdk = 36
        minSdk = 24
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    jvm {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ConnectTagCoroutineDispatchers"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.coroutines.core)
        }
    }
}

publishing {
    publications.withType<MavenPublication> {
        pom {
            name.set("ConnectTag Coroutine Dispatchers (KMP)")
            description.set("Injectable Coroutine DispatcherProvider contracts and platform-specific implementations for Kotlin Multiplatform")
            url.set("https://github.com/connecttag/coroutine-dispatchers-kmp")
            licenses {
                license {
                    name.set("The Apache License, Version 2.0")
                    url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                }
            }
            developers {
                developer {
                    id.set("connecttagye")
                    name.set("Connect Tag")
                    email.set("connecttagye@gmail.com")
                }
            }
            scm {
                connection.set("scm:git:https://github.com/connecttag/coroutine-dispatchers-kmp.git")
                developerConnection.set("scm:git:ssh://git@github.com:connecttag/coroutine-dispatchers-kmp.git")
                url.set("https://github.com/connecttag/coroutine-dispatchers-kmp/tree/main")
            }
        }
    }
}
