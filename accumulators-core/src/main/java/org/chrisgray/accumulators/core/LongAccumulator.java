package org.chrisgray.accumulators.core;

import com.google.common.base.Optional;

public abstract class LongAccumulator {
    public abstract void accumulate(long value);

    public void accumulate(Optional<Long> value) {
        if (value.isPresent()) {
            accumulate(value.get());
        }
    }

    public abstract long result();
}
