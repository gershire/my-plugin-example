package com.example.plugin

import com.example.plugin.api.Plugin

class PluginC : Plugin {
    override fun execute() {
        println("Plugin C execution...")
    }

    override fun init() {
        println("Plugin C Initialized")
    }
}
