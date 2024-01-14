import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import kotlin.random.Random

object TestData {
    val data = getJson("data.json")
    val benchmarkInput = (1..12).map {
        val input1 = (0..2000)
            .map { Random.nextInt(from = 0, until = 10000) }
            .sorted()
            .toIntArray()
        val input2 = (0..2000)
            .map { Random.nextInt(from = 0, until = 10000) }
            .sorted()
            .toIntArray()
        input1 to input2
    }

    private fun getJson(fileName: String): List<BenchmarkData> {
        val path = Paths.get(Objects.requireNonNull(TestData::class.java.getResource(fileName)).toURI())
        val string = String(Files.readAllBytes(path))
        return Json.decodeFromString<List<BenchmarkData>>(string)
    }
}

@Serializable
data class BenchmarkData(val inputValue: MedianArrayData, val outputValue: Double)

@Serializable
data class MedianArrayData(val nums1: IntArray, val nums2: IntArray)
