import org.jetbrains.compose.compose
import java.util.Properties

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose").version(Versions.compose_jb)
    id("com.android.library")
    id("maven-publish")
    id("signing")
}

group = "io.github.qdsfdhvh"
version = "1.0.0"

kotlin {
    android()
    jvm()
    ios()
    sourceSets {
        val commonMain by getting {
            kotlin.srcDir("src/commonMain/actual")
            dependencies {
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.runtime)
                implementation(compose.material)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
                // TODO: remove when auto implementation
                implementation("org.jetbrains.compose.ui:ui-util:${Versions.compose_jb}")
            }
        }
        val androidMain by getting {
            dependencies {
                // TODO: remove next 3 dependencies when b/202810604 is fixed
                implementation("androidx.savedstate:savedstate-ktx:1.2.0-rc01")
                implementation("androidx.lifecycle:lifecycle-runtime:2.3.0")
                implementation("androidx.lifecycle:lifecycle-viewmodel:2.3.0")
            }
        }
        val jvmMain by sourceSets.getting
        val iosMain by sourceSets.getting
    }
}

android {
    compileSdk = Versions.Android.compile
    buildToolsVersion = Versions.Android.buildTools
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.Android.min
        targetSdk = Versions.Android.target
    }
    compileOptions {
        sourceCompatibility = Versions.Java.java
        targetCompatibility = Versions.Java.java
    }
}

ext {
    val publishPropFile = rootProject.file("publish.properties")
    if (publishPropFile.exists()) {
        Properties().apply {
            load(publishPropFile.inputStream())
        }.forEach { name, value ->
            set(name.toString(), value)
        }
    } else {
        set("signing.keyId", System.getenv("SIGNING_KEY_ID"))
        set("signing.password", System.getenv("SIGNING_PASSWORD"))
        set("signing.secretKeyRingFile", System.getenv("SIGNING_SECRET_KEY_RING_FILE"))
        set("ossrhUsername", System.getenv("OSSRH_USERNAME"))
        set("ossrhPassword", System.getenv("OSSRH_PASSWORD"))
    }
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing {
    signing {
        sign(publishing.publications)
    }
    repositories {
        maven {
            val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            url = if (version.toString().endsWith("SNAPSHOT")) {
                uri(snapshotsRepoUrl)
            } else {
                uri(releasesRepoUrl)
            }
            credentials {
                username = project.ext.get("ossrhUsername").toString()
                password = project.ext.get("ossrhPassword").toString()
            }
        }
    }
    publications.withType<MavenPublication> {
        artifact(javadocJar.get())
        pom {
            name.set("material3")
            description.set("Compose Material3.")
            url.set("https://github.com/qdsfdhvh/compose-material3")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set("Seiko")
                    name.set("Seiko Des")
                    email.set("seiko_des@outlook.com")
                }
            }
            scm {
                url.set("https://github.com/qdsfdhvh/compose-material3")
                connection.set("scm:git:git://github.com/qdsfdhvh/compose-material3.git")
                developerConnection.set("scm:git:git://github.com/qdsfdhvh/compose-material3.git")
            }
        }
    }
}
