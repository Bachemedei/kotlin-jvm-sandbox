package dev.bachemedei

import TestData
import kotlinx.benchmark.*
import java.util.*

import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Warmup(iterations = 0)
@Measurement(iterations = 1, timeUnit = TimeUnit.SECONDS)
class Benchmarks {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    fun benchmarkSolution1() {
        TestData.data.forEach {
            isValid1(it.inputValue)
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    fun benchmarkSolution2() {
        TestData.data.forEach {
            isValid2(it.inputValue)
        }
    }
}

