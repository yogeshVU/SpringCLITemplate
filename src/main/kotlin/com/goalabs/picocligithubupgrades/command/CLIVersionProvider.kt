package com.goalabs.picocligithubupgrades.command

import com.goalabs.picocligithubupgrades.util.Utils
import picocli.CommandLine

class CLIVersionProvider: CommandLine.IVersionProvider   {
    override fun getVersion(): Array<String> {
        return Utils.getCurrentAndReleaseVersion()
    }
}
