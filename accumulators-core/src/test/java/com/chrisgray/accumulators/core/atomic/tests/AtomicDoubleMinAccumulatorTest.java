package com.chrisgray.accumulators.core.atomic.tests;

import com.chrisgray.accumulators.core.atomic.AtomicDoubleMinAccumulator;
import com.chrisgray.accumulators.core.min.tests.DoubleMinAccumulatorTest;
import org.junit.Before;

public class AtomicDoubleMinAccumulatorTest extends DoubleMinAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicDoubleMinAccumulator();
    }
}
