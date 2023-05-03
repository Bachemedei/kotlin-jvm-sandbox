package serialization

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

const val json =
    """
{
    "key1": "value1",
    "key2": "value2",
    "key3": "value3",
    "key4": "value4",
    "key5": "value5"
}
"""

@State(Scope.Benchmark)
@Fork(0)
@Warmup(iterations = 3)
@Measurement(iterations = 1, timeUnit = TimeUnit.SECONDS)
class SerializationBenchmarks {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun retrieveSerializerPerIteration() {
        repeat(1000) {
            val metadata: Map<String, String> = Json.decodeFromString(json)
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun retrieveSerializerOnce() {
        val serializer = serializer<Map<String, String>>()
        repeat(1000) {
            val metadata: Map<String, String> = Json.decodeFromString(serializer, json)
        }
    }
}