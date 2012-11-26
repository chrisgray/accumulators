package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicLongSumAccumulator;
import org.chrisgray.accumulators.core.sum.tests.LongSumAccumulatorTest;
import org.junit.Before;

public class AtomicLongSumAccumulatorTest extends LongSumAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicLongSumAccumulator();
    }
}