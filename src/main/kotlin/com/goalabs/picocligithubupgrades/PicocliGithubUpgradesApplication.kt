package com.goalabs.picocligithubupgrades

import com.goalabs.picocligithubupgrades.command.EntryCmd
import com.goalabs.picocligithubupgrades.command.UpdateCmd
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import picocli.CommandLine

@SpringBootApplication
class PicocliGithubUpgradesApplication
	(
	private val generateUpdateCommand: UpdateCmd,
	private val generateEntryCmd: EntryCmd
): CommandLineRunner
{
	override fun run(vararg args: String?) {

		CommandLine(generateEntryCmd)
			.addSubcommand(generateUpdateCommand)
			.execute(*args)
	}
}


fun main(args: Array<String>) {
	runApplication<PicocliGithubUpgradesApplication>(*args)
}
