package com.goalabs.picocligithubupgrades.command

import picocli.CommandLine

class CLIVersionProvider: CommandLine.IVersionProvider   {
    override fun getVersion(): Array<String> {
        val props = this::class.java.classLoader.getResourceAsStream("version.properties").use {
            java.util.Properties().apply { load(it) }
        }
        return arrayOf(props["version"] as String)
    }
}
