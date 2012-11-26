package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicExponentialSmoothingAccumulator;
import org.chrisgray.accumulators.core.smoothing.tests.ExponentialSmoothingAccumulatorTest;
import org.junit.Before;

public class AtomicExponentialSmoothingAccumulatorTest extends ExponentialSmoothingAccumulatorTest {
    @Override
    @Before
    public void setup() {
        final double alpha = 0.75;
        accumulator = new AtomicExponentialSmoothingAccumulator(alpha);
    }
}
