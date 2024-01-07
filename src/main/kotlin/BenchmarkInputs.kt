import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

private const val PALINDROME_DATA_FILE = "palindrome-data.json"

object BenchmarkInputs {
    val palindromeData = getJson(PALINDROME_DATA_FILE)

    private fun getJson(fileName: String): List<BenchmarkData> {
        val path = Paths.get(Objects.requireNonNull(BenchmarkInputs::class.java.getResource(fileName)).toURI())
        val string = String(Files.readAllBytes(path))
        return Json.decodeFromString<List<BenchmarkData>>(string)
    }
}

@Serializable
data class BenchmarkData(val inputValue: String, val outputValues: List<String>)
