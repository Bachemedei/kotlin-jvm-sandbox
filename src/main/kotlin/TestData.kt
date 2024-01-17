import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

object TestData {
    val data = getJson("data.json")

    private fun getJson(fileName: String): List<BenchmarkData> {
        val path = Paths.get(Objects.requireNonNull(TestData::class.java.getResource(fileName)).toURI())
        val string = String(Files.readAllBytes(path))
        return Json.decodeFromString<List<BenchmarkData>>(string)
    }
}

@Serializable
data class BenchmarkData(val inputValue1: List<Int>, val inputValue2: List<Int>, val outputValue: List<Int>)
