package com.goalabs.picocligithubupgrades.command

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import picocli.CommandLine
import java.net.HttpURLConnection
import java.net.URL

@Configuration
@CommandLine.Command(name = "update", description = ["Check GitHub for an update to CLI."],
    mixinStandardHelpOptions = true)
class UpdateCmd :  Runnable {
    override fun run() {
        println("Checking for updates...")
        checkGithubforUpdates()


    }
}


@Suppress("unused")
class Release {
    var html_url: String? = ""
    var tag_name: String? = ""
    var name: String? = ""
    var published_at: String? = ""
    var prerelease: Boolean = false
}




fun checkGithubforUpdates() {
    println("Checking for updates...")
    val path = URL("https://api.github.com/repos/webgme/webgme-taxonomy/releases/latest")
    // read this URL using the webclient
    val webClient = WebClient.create()
    val response = webClient.get()
        .uri(path.toURI())
        .retrieve()
        .bodyToMono(Release::class.java)
        .block()

    // parse the response
    print("Response: $response")

    println("Download URL: ${response?.html_url}")
    println("Tag: ${response?.tag_name}")
    println("Version: ${response?.name}")
    println("Published: ${response?.published_at}")



}
