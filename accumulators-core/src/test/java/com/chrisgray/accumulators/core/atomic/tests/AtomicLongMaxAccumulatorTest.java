package com.chrisgray.accumulators.core.atomic.tests;

import com.chrisgray.accumulators.core.atomic.AtomicLongMaxAccumulator;
import com.chrisgray.accumulators.core.max.tests.LongMaxAccumulatorTest;
import org.junit.Before;

public class AtomicLongMaxAccumulatorTest extends LongMaxAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicLongMaxAccumulator();
    }
}
