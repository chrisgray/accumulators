package com.chrisgray.accumulators.core.atomic.tests;

import com.chrisgray.accumulators.core.atomic.AtomicMedianAccumulator;
import com.chrisgray.accumulators.core.median.tests.LongMedianAccumulatorTest;
import org.junit.Before;

public class AtomicLongMedianAccumulatorTest extends LongMedianAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicMedianAccumulator<Long>();
    }
}
