package com.github.akash1047.redengine

import org.lwjgl.glfw.GLFW

object Keyboard {
    var keys = IntArray(11)

    fun press(key: Int) {
        keys[key / 32] = keys[key / 32] or 1.shl(key % 32)
    }

    fun release(key: Int) {
        keys[key / 32] = keys[key / 32] and 1.shl(key % 32).inv()
    }

    fun isKeyDown(key: Int): Boolean =
        (keys[key / 32] and 1.shl(key % 32)) != 0

    operator fun get(key: Int) =
        (keys[key / 32] and 1.shl(key % 32)) != 0

    operator fun set(key: Int, value: Int) {
        if (value == GLFW.GLFW_PRESS) press(key)
        else if (value == GLFW.GLFW_RELEASE) release(key)
    }

    operator fun set(key: Int, value: Boolean) {
        if (value) press(key) else release(key)
    }

    fun callback(window: Long, key: Int, scancode: Int, action: Int, mods: Int) {
        if (action == GLFW.GLFW_PRESS) press(key)
        else if (action == GLFW.GLFW_RELEASE) release(key)
    }
}