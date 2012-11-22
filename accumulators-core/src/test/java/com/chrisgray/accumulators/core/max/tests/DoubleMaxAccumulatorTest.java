package com.chrisgray.accumulators.core.max.tests;

import com.chrisgray.accumulators.core.DoubleAccumulator;
import com.chrisgray.accumulators.core.max.DoubleMaxAccumulator;
import com.google.common.collect.ImmutableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DoubleMaxAccumulatorTest {
    protected DoubleAccumulator accumulator;

    @Before
    public void setup() {
        accumulator = new DoubleMaxAccumulator();
    }

    @After
    public void tearDown() {
        accumulator = null;
    }

    @Test(expected = IllegalStateException.class)
    public void none() {
        assertThat(accumulator.result(), is(0.0));
    }

    @Test
    public void multiple() {
        for(Integer i : ImmutableList.of(1, 4, -1, 3, 2)) {
            accumulator.accumulate(i.doubleValue());
        }
        assertThat(accumulator.result(), is(4d));
    }

    @Test
    public void overrideDefault() {
        assertThat(new DoubleMaxAccumulator(5.0).result(), is(5.0));

        accumulator = new DoubleMaxAccumulator(1.0);
        accumulator.accumulate(2.1);
        assertThat(accumulator.result(), is(2.1));
    }

    @Test
    public void defaultValue() {
        assertThat(new DoubleMaxAccumulator(-1.0).result(), is(-1.0));
    }
}
