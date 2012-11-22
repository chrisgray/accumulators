package com.chrisgray.accumulators.core.atomic.tests;

import com.chrisgray.accumulators.core.atomic.AtomicStdDevAccumulator;
import com.chrisgray.accumulators.core.stddev.tests.StdDevAccumulatorTest;
import org.junit.Before;

public class AtomicStdDevAccumulatorTest extends StdDevAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicStdDevAccumulator();
    }
}
