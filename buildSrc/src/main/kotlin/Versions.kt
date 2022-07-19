import org.gradle.api.JavaVersion

object Versions {

    object Android {
        const val min = 21
        const val compile = 32
        const val target = compile
        const val buildTools = "32.0.0"
    }

    object Java {
        const val jvmTarget = "11"
        val java = JavaVersion.VERSION_11
    }

    const val compose_jb = "1.2.0-alpha01-dev745"
    const val compose = "1.3.0-alpha01"
}