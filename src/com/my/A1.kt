package com.my

open class A1(open val value: String) {
    init {
        println(value.length)
    }
}

class B(override val value: String) : A1(value)

fun main(args: Array<String>) {
    B("a")
}
