package com.goalabs.picocligithubupgrades.command

import com.goalabs.picocligithubupgrades.util.Utils
import org.springframework.context.annotation.Configuration
import picocli.CommandLine

@Configuration
@CommandLine.Command(name = "update", description = ["Check GitHub for an update to CLI."],
    mixinStandardHelpOptions = true)
class UpdateCmd :  Runnable {
    override fun run() {
         Utils.getCurrentAndReleaseVersion()
    }
}




