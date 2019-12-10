package com.example.plugin.a

import com.example.plugin.api.Plugin

class PluginA : Plugin {
    override fun execute() {
        println("Plugin A execution...")
    }

    override fun init() {
        println("Plugin A Initialized")
    }
}
