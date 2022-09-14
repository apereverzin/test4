package com.my.tutorial.properties

class DelegatedLazyProperty(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}
