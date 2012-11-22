package com.chrisgray.accumulators.core.min;

import com.chrisgray.accumulators.core.LongAccumulator;

public class LongMinAccumulator extends LongAccumulator {
    protected long min = Long.MAX_VALUE;
    protected boolean set = false;

    public LongMinAccumulator() {
    }

    public LongMinAccumulator(long min) {
        accumulate(min);
    }

    public void accumulate(long value) {
        if (set) {
            min = Math.min(min, value);
        } else {
            min = value;
            set = true;
        }
    }

    public long result() {
        if (set) {
            return min;
        } else {
            throw new IllegalStateException("No min has been accumulated");
        }
    }
}