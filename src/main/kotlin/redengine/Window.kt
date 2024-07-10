package com.github.akash1047.redengine

import com.github.akash1047.glfw.OpenglProfile
import com.github.akash1047.glfw.WindowHint
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil.NULL

object Window {
    private const val WIDTH = 600
    private const val HEIGHT = 400
    private const val TITLE = "Mario"
    private val window: Long

    init {
        GLFWErrorCallback.createPrint(System.err).set()

        if (!glfwInit())
            throw Error("Unable to initialize GLFW")

        WindowHint()
            .maximized(true)
            .resizable(true)
            .visible(false)
            .openglProfile(OpenglProfile.Core)
            .contextVersion(4, 6)

        window = glfwCreateWindow(WIDTH, HEIGHT, TITLE, NULL, NULL)

        if (window == NULL) {
            throw RuntimeException("Failed to create the GLFW window")
        }

        glfwSetKeyCallback(window, Keyboard::callback)

        glfwMakeContextCurrent(window)
        glfwSwapInterval(1)
        glfwShowWindow(window)

        GL.createCapabilities()
    }

    fun run() {
        glClearColor(0.5f, 0.3f, 0.5f, 1f)

        while (!glfwWindowShouldClose(window)) {
            glfwPollEvents()

            if (Keyboard[GLFW_KEY_ESCAPE]) {
                glfwSetWindowShouldClose(window, true)
            }

            glClear(GL_COLOR_BUFFER_BIT)
            glfwSwapBuffers(window)
        }

        cleanup()
    }

    private fun cleanup() {
        glfwDestroyWindow(window)
        glfwTerminate()
        glfwSetErrorCallback(null)?.free()
    }
}