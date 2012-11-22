package com.chrisgray.accumulators.core.atomic;

import com.chrisgray.accumulators.core.LongAccumulator;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongSumAccumulator extends LongAccumulator {
    private AtomicLong sum = new AtomicLong();

    @Override
    public void accumulate(long value) {
        sum.addAndGet(value);
    }

    @Override
    public long result() {
        return sum.get();
    }
}
