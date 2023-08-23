package com.goalabs.picocligithubupgrades.command
import org.springframework.context.annotation.Configuration
import picocli.CommandLine
import java.util.concurrent.Callable

@Configuration
@CommandLine.Command(
    version = ["app_cli", "1.0.0"],
    mixinStandardHelpOptions = true,
    description = ["Sample App CLI for testing Picocli Github Upgrades wuth Spring Boot"]
)
class EntryCmd
 : Callable<Int> {
    override fun call(): Int {
        return 0
    }
}