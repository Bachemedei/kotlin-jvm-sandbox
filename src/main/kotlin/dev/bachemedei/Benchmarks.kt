package dev.bachemedei

import TestData
import kotlinx.benchmark.*
import java.util.*

import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Warmup(iterations = 0)
@Measurement(iterations = 1, timeUnit = TimeUnit.MILLISECONDS)
class Benchmarks {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    fun benchmarkSolution1() {
        TestData.data.forEach {
            solution1(it.inputValue)
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    fun benchmarkSolution2() {
        TestData.data.forEach {
            solution2(it.inputValue)
        }
    }
}

