import org.gradle.api.JavaVersion

object Versions {

    object Android {
        const val min = 21
        const val compile = 33
    }

    object Java {
        const val jvmTarget = "11"
        val java = JavaVersion.VERSION_11
    }

    const val compose_jb = "1.3.0"
    const val compose = "1.3.1"
}