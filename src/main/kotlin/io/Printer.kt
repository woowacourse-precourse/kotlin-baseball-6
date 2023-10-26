package io

class Printer {
    fun print(renderable: Renderable) {
        println(renderable.render())
    }
}