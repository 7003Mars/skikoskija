package me.mars

// Skija
//import io.github.humbleui.skija.DirectContext
//import io.github.humbleui.skija.impl.Library
// Skiko
import org.jetbrains.skia.DirectContext
import org.jetbrains.skiko.Library


import org.lwjgl.glfw.GLFW.*
import org.lwjgl.system.MemoryUtil.NULL

fun main() {
    glfwInit()
    val window: Long = glfwCreateWindow(100, 100, "Title", NULL, NULL)
    if (window == NULL) throw RuntimeException("Failed to create window")
    glfwMakeContextCurrent(window)


//    Library.load()
    println("Makegl?")
    DirectContext.makeGL()
    println("Made")
}