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
        TestData.benchmarkInput.forEach { (input1, input2) ->
            initialSolution(input1, input2)
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    fun benchmarkSolution2() {
        TestData.benchmarkInput.forEach { (input1, input2) ->
            finalSolution(input1, input2)
        }
    }
}

