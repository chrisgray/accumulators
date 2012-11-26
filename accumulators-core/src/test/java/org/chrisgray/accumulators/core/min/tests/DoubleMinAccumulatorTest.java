package org.chrisgray.accumulators.core.min.tests;

import com.google.common.collect.ImmutableList;
import org.chrisgray.accumulators.core.DoubleAccumulator;
import org.chrisgray.accumulators.core.min.DoubleMinAccumulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DoubleMinAccumulatorTest {
    protected DoubleAccumulator accumulator;

    @Before
    public void setup() {
        accumulator = new DoubleMinAccumulator();
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
    public void minAccumulatorWorks() {
        for(Integer i : ImmutableList.of(1, 2, -1, 3, 4)) {
            accumulator.accumulate(i.doubleValue());
        }
        assertThat(accumulator.result(), is(-1d));
    }


    @Test
    public void overrideDefault() {
        assertThat(new DoubleMinAccumulator(5.0).result(), is(5.0));

        accumulator = new DoubleMinAccumulator(1.0);
        accumulator.accumulate(2.1);
        assertThat(accumulator.result(), is(1.0));
    }

    @Test
    public void defaultValue() {
        assertThat(new DoubleMinAccumulator(-1.0).result(), is(-1.0));
    }
}