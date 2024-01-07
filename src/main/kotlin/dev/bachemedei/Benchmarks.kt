package dev.bachemedei

import BenchmarkInputs
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
    fun palindrome1() {
        BenchmarkInputs.palindromeData.forEach {
            val actualOutput = longestPalindrome1(it.inputValue)
            assert(it.outputValues.contains(actualOutput))
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun palindrome2() {
        BenchmarkInputs.palindromeData.forEach {
            val actualOutput = longestPalindrome2(it.inputValue)
            assert(it.outputValues.contains(actualOutput))
        }
    }
}

