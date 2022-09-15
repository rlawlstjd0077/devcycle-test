
import com.devcycle.sdk.server.api.DVCClient
import com.devcycle.sdk.server.model.User
import com.devcycle.sdk.server.model.Variable
import java.util.UUID


/**
 * @author Jay
 */
class DevCycle {
    private val dvcClient = DVCClient("server-af93dfe9-955e-44a0-ae23-7e722d698315");

    fun useFeature() {

        // Create user object
        val user = User.builder()
            .userId(UUID.randomUUID().toString())
            .build()

        // The default value can be of type string, boolean, number, or JSON
        val key = "release-flag"
        val defaultValue = false

        // Fetch variable values using the identifier key, with a default value and user object
        val variable: Variable<Boolean> = dvcClient.variable(user, key, defaultValue)
        val variableNumber: Variable<Int> = dvcClient.variable(user, "number", 0)

        // If the variable doesn't exist isDefaulted will be true
        System.out.print(variable.getIsDefaulted())

        println(variable.value)
        println(variableNumber.value)
    }
}

fun main() {
    while (true) {
        DevCycle().useFeature()
        Thread.sleep(4000)
    }
}