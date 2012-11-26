package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicLongMaxAccumulator;
import org.chrisgray.accumulators.core.max.tests.LongMaxAccumulatorTest;
import org.junit.Before;

public class AtomicLongMaxAccumulatorTest extends LongMaxAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicLongMaxAccumulator();
    }
}
