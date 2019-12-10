package com.example.pluginmain

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PluginMainApplication

fun main(args: Array<String>) {
    runApplication<PluginMainApplication>(*args)
}
