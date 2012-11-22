package com.chrisgray.accumulators.core.sum;

import com.chrisgray.accumulators.core.LongAccumulator;

public class LongSumAccumulator extends LongAccumulator {
    protected long sum = 0L;

    public LongSumAccumulator() {
    }

    public LongSumAccumulator(long sum) {
        accumulate(sum);
    }

    @Override
    public void accumulate(long value) {
        sum += value;
    }

    @Override
    public long result() {
        return sum;
    }
}