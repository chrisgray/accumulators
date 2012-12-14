package org.chrisgray.accumulators.core.stddev.tests;

import org.chrisgray.accumulators.core.DoubleAccumulator;
import org.chrisgray.accumulators.core.stddev.StdDevAccumulator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StdDevAccumulatorTest {
    protected DoubleAccumulator accumulator;

    @Before
    public void setup() {
        accumulator = new StdDevAccumulator();
    }

    @Test(expected = IllegalStateException.class)
    public void none() {
        accumulator.result();
    }

    @Test
    public void one() {
        accumulator.accumulate(1.1);
        assertThat(accumulator.result(), is(0.0));
    }

    @Test
    public void simple() {
        accumulator.accumulate(1.0);
        accumulator.accumulate(0.5);
        assertThat(accumulator.result(), is(0.25));
    }

    @Test
    public void complex() {
        accumulator.accumulate(600);
        accumulator.accumulate(470);
        accumulator.accumulate(170);
        accumulator.accumulate(430);
        accumulator.accumulate(300);
        assertThat(accumulator.result(), is(147.32277488562318));
    }
}
