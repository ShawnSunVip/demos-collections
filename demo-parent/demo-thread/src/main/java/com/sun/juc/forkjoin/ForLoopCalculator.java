package com.sun.juc.forkjoin;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * for循环计算
 * @author sunxiang
 * @date 2020-12-23 16:25
 **/
public class ForLoopCalculator {

    public static long sumUp(long[] numbers) {
        long total = 0;
        for (long i : numbers) {
            total += i;
        }
        return total;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 100000000).toArray();

        Instant start = Instant.now();
        ForLoopCalculator calculator = new ForLoopCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result);
    }
}
