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
    iosX64()
    iosArm64()
    macosX64()
    macosArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.runtime)
                implementation(compose.material)
                implementation(compose.animation)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                // TODO: remove when auto implementation
                implementation("org.jetbrains.compose.ui:ui-util:${Versions.compose_jb}")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.compose.animation:animation-core:${Versions.compose}")
                implementation("androidx.compose.foundation:foundation:${Versions.compose}")
                implementation("androidx.compose.foundation:foundation-layout:${Versions.compose}")
                implementation("androidx.compose.material:material-icons-core:${Versions.compose}")
                implementation("androidx.compose.material:material-ripple:${Versions.compose}")
                implementation("androidx.compose.runtime:runtime:${Versions.compose}")
                implementation("androidx.compose.ui:ui-util:${Versions.compose}")
                implementation("androidx.compose.ui:ui-graphics:${Versions.compose}")
                implementation("androidx.compose.ui:ui-text:${Versions.compose}")

                // TODO: remove next 3 dependencies when b/202810604 is fixed
                implementation("androidx.savedstate:savedstate-ktx:1.2.0")
                implementation("androidx.lifecycle:lifecycle-runtime:2.5.1")
                implementation("androidx.lifecycle:lifecycle-viewmodel:2.5.1")
            }
        }
        val noAndroidMain by creating {
            dependsOn(commonMain)
        }
        val jvmMain by getting {
            dependsOn(noAndroidMain)
        }
        val iosMain by creating {
            dependsOn(noAndroidMain)
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val macosMain by creating {
            dependsOn(noAndroidMain)
        }
        val macosX64Main by getting {
            dependsOn(macosMain)
        }
        val macosArm64Main by getting {
            dependsOn(macosMain)
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
