package com.chrisgray.accumulators.core.max;

import com.chrisgray.accumulators.core.LongAccumulator;

public class LongMaxAccumulator extends LongAccumulator {
    protected long max = Long.MIN_VALUE;
    protected boolean set = false;

    public LongMaxAccumulator() {
    }

    public LongMaxAccumulator(long max) {
        accumulate(max);
    }

    @Override
    public void accumulate(long value) {
        if (set) {
            max = Math.max(max, value);
        } else {
            max = value;
            set = true;
        }
    }

    @Override
    public long result() {
        if (set) {
            return max;
        } else {
            throw new IllegalStateException("No max has been accumulated");
        }
    }
}
