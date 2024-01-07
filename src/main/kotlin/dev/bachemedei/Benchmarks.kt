package dev.bachemedei

import TestData
import kotlinx.benchmark.*
import java.util.*

import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Warmup(iterations = 1)
@Measurement(iterations = 1, timeUnit = TimeUnit.SECONDS)
class Benchmarks {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun benchmarkSolution() {
        TestData.data.forEach {
            TODO()
        }
    }
}

