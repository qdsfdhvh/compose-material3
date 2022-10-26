import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    kotlin("android").apply(false)
    id("org.jetbrains.compose") version Versions.compose_jb apply false
    id("com.vanniktech.maven.publish") version "0.22.0" apply false
}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-Xcontext-receivers",
                "-Xskip-prerelease-check",
            )
        }
    }

    group = "io.github.qdsfdhvh"
    version = "1.0.7"

    plugins.withId("com.vanniktech.maven.publish.base") {
        @Suppress("UnstableApiUsage")
        configure<MavenPublishBaseExtension> {
            publishToMavenCentral(SonatypeHost.S01, automaticRelease = true)
            signAllPublications()
            pom {
                description.set("Compose Material3.")
                name.set(project.name)
                url.set("https://github.com/qdsfdhvh/compose-material3")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        id.set("Seiko")
                        name.set("SeikoDes")
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
}