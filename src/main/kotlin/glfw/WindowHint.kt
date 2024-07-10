package com.github.akash1047.glfw

import org.lwjgl.glfw.GLFW

class WindowHint {
    fun default(): WindowHint {
        GLFW.glfwDefaultWindowHints()
        return this
    }

    fun resizable(value: Int): WindowHint {
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, value)
        return this
    }

    fun visible(value: Int): WindowHint {
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, value)
        return this
    }

    fun maximized(value: Int): WindowHint {
        GLFW.glfwWindowHint(GLFW.GLFW_MAXIMIZED, value)
        return this
    }

    fun resizable(value: Boolean): WindowHint =
        resizable(if (value) GLFW.GLFW_TRUE else GLFW.GLFW_FALSE)

    fun visible(value: Boolean): WindowHint =
        visible(if (value) GLFW.GLFW_TRUE else GLFW.GLFW_FALSE)

    fun maximized(value: Boolean): WindowHint =
        maximized(if (value) GLFW.GLFW_TRUE else GLFW.GLFW_FALSE)

    fun contextVersion(major: Int, minor: Int): WindowHint {
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, major)
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, minor)
        return this
    }

    fun clientApi(api: ClientApi): WindowHint {
        GLFW.glfwWindowHint(GLFW.GLFW_CLIENT_API, api.value)
        return this
    }

    fun openglProfile(profile: OpenglProfile): WindowHint {
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, profile.value)
        return this
    }
}