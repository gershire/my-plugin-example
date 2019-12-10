package com.example.pluginmain

import com.example.plugin.api.Plugin
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.net.URLClassLoader
import javax.annotation.PostConstruct

data class ExecutePluginRequest(
        val className: String
)

data class ExecutePluginResponse(
        val message: String
)

@RestController
class PluginController(@Value("\${plugins.dir}") private val pluginsDir: String) {

    private lateinit var loader: URLClassLoader

    @PostConstruct
    fun loadJars() {
        val files = File(pluginsDir).listFiles()
                ?.filter { it.extension == "jar" }
                ?.map { it.toURI().toURL() } ?: listOf()
        loader = URLClassLoader.newInstance(files.toTypedArray())
    }

    @PostMapping("/plugin")
    fun execPlugin(@RequestBody request: ExecutePluginRequest): ExecutePluginResponse {
        val plugin = try {
            loader.loadClass(request.className).newInstance() as Plugin
        } catch (e: ClassNotFoundException) {
            loadJars()
            loader.loadClass(request.className).newInstance() as Plugin
        }
        plugin.init()
        plugin.execute()
        return ExecutePluginResponse("Plugin executed successfully")
    }
}
