package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicMedianAccumulator;
import org.chrisgray.accumulators.core.median.tests.LongMedianAccumulatorTest;
import org.junit.Before;

public class AtomicLongMedianAccumulatorTest extends LongMedianAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicMedianAccumulator<Long>();
    }
}
