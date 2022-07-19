import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.MavenPublishBaseExtension

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("com.vanniktech.maven.publish.base")
}

kotlin {
    android {
        publishLibraryVariants("debug", "release")
    }
    jvm()
    ios()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.runtime)
                implementation(compose.material)
                implementation(compose.animation)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
                // TODO: remove when auto implementation
                implementation("org.jetbrains.compose.ui:ui-util:${Versions.compose_jb}")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.compose.material:material:${Versions.compose}")
                implementation("androidx.compose.animation:animation:${Versions.compose}")
                implementation("androidx.compose.ui:ui-util:${Versions.compose}")

                // TODO: remove next 3 dependencies when b/202810604 is fixed
                implementation("androidx.savedstate:savedstate-ktx:1.2.0")
                implementation("androidx.lifecycle:lifecycle-runtime:2.5.0")
                implementation("androidx.lifecycle:lifecycle-viewmodel:2.5.0")
            }
        }
        val noAndroidMain by creating {
            dependsOn(commonMain)
        }
        val jvmMain by getting {
            dependsOn(noAndroidMain)
        }
        val iosMain by getting {
            dependsOn(noAndroidMain)
        }
    }
}

android {
    namespace = "io.github.qdsfdhvh.material3"
    compileSdk = Versions.Android.compile
    buildToolsVersion = Versions.Android.buildTools
    defaultConfig {
        minSdk = Versions.Android.min
        targetSdk = Versions.Android.target
    }
    compileOptions {
        sourceCompatibility = Versions.Java.java
        targetCompatibility = Versions.Java.java
    }
}

@Suppress("UnstableApiUsage")
configure<MavenPublishBaseExtension> {
    configure(KotlinMultiplatform())
}
