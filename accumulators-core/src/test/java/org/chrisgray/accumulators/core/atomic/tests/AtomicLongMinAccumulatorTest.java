package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicLongMinAccumulator;
import org.chrisgray.accumulators.core.min.tests.LongMinAccumulatorTest;
import org.junit.Before;

public class AtomicLongMinAccumulatorTest extends LongMinAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicLongMinAccumulator();
    }
}
