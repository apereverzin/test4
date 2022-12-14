package com.my.tutorial.properties

class LazyProperty(val initializer: () -> Int) {
    var v: Int? = null
    val lazy: Int
        get() {
            if (v == null) {
                v = initializer()
            }
            return v!!
        }
}
