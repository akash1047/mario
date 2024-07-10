package com.github.akash1047.glfw

import org.lwjgl.glfw.GLFW

enum class ClientApi(val value: Int) {
    Opengl(GLFW.GLFW_OPENGL_API),
    OpenglEs(GLFW.GLFW_OPENGL_ES_API),
    None(GLFW.GLFW_NO_API),
}

enum class OpenglProfile(val value: Int) {
    Any(GLFW.GLFW_OPENGL_ANY_PROFILE),
    Compat(GLFW.GLFW_OPENGL_COMPAT_PROFILE),
    Core(GLFW.GLFW_OPENGL_CORE_PROFILE),
}