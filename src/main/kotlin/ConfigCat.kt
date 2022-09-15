import com.configcat.ConfigCatClient
import com.configcat.ConfigCatUser
import com.configcat.getValue
import com.configcat.log.LogLevel
import kotlinx.coroutines.runBlocking
import java.util.UUID

/**
 * @author Jay
 */
class ConfigCat {

    suspend fun useFeature() {
        val client =
            ConfigCatClient("yJbaCGDmukWGQu7bVWRVkA/1WZ54D8KZ0C5pHepEZwkOQ") { // <-- This is the actual SDK Key for your 'Test Environment' environment.
                logLevel = LogLevel.INFO
            }

        val myFeatureflag = client.getValue("myFeatureflag", false, ConfigCatUser(UUID.randomUUID().toString()))

        println("myFeatureflag's value from ConfigCat: $myFeatureflag")
    }
}

fun main() {
    runBlocking {
        while (true) {
            ConfigCat().useFeature()
        }
    }
}