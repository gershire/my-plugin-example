package com.example.plugin.b

import com.example.plugin.api.Plugin

class PluginB : Plugin {
    override fun execute() {
        println("Plugin B execution...")
    }

    override fun init() {
        println("Plugin B Initialized")
    }
}
