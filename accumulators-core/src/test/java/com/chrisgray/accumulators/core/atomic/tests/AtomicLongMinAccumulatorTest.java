package com.chrisgray.accumulators.core.atomic.tests;

import com.chrisgray.accumulators.core.atomic.AtomicLongMinAccumulator;
import com.chrisgray.accumulators.core.min.tests.LongMinAccumulatorTest;
import org.junit.Before;

public class AtomicLongMinAccumulatorTest extends LongMinAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicLongMinAccumulator();
    }
}
