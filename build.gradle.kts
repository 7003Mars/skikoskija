plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "me.mars"
version = "1.0-SNAPSHOT"

val lib by extra(Type.Skiko)
val lwjglVer by extra("3.3.1")

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.lwjgl:lwjgl:$lwjglVer")
    implementation("org.lwjgl:lwjgl-glfw:$lwjglVer")
    implementation("org.lwjgl:lwjgl-opengl:$lwjglVer")
    runtimeOnly("org.lwjgl:lwjgl:$lwjglVer:natives-windows")
    runtimeOnly("org.lwjgl:lwjgl-glfw:$lwjglVer:natives-windows")
    runtimeOnly("org.lwjgl:lwjgl-opengl:$lwjglVer:natives-windows")

    when(lib) {
        Type.Skiko -> {
            implementation("org.jetbrains.skiko:skiko:${lib.version}")
            implementation("org.jetbrains.skiko:skiko-awt-runtime-windows-x64:${lib.version}")
        }
        Type.Skija -> {
            implementation("io.github.humbleui:skija-shared:${lib.version}")
            implementation("io.github.humbleui:skija-windows-x64:${lib.version}")
        }
    }
}


enum class Type(val version: String) {
    Skiko("0.7.90"),
    Skija("0.116.2")
}

application {
    mainClass = "me.mars.MainKt"
}