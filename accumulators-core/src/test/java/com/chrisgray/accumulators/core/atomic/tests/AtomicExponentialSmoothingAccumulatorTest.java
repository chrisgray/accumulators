package com.chrisgray.accumulators.core.atomic.tests;

import com.chrisgray.accumulators.core.atomic.AtomicExponentialSmoothingAccumulator;
import com.chrisgray.accumulators.core.smoothing.tests.ExponentialSmoothingAccumulatorTest;
import org.junit.Before;

public class AtomicExponentialSmoothingAccumulatorTest extends ExponentialSmoothingAccumulatorTest {
    @Override
    @Before
    public void setup() {
        final double alpha = 0.75;
        accumulator = new AtomicExponentialSmoothingAccumulator(alpha);
    }
}
