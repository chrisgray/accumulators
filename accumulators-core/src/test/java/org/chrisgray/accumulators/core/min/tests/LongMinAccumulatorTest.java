package org.chrisgray.accumulators.core.min.tests;

import com.google.common.collect.ImmutableList;
import org.chrisgray.accumulators.core.LongAccumulator;
import org.chrisgray.accumulators.core.min.LongMinAccumulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LongMinAccumulatorTest {
    protected LongAccumulator accumulator;

    @Before
    public void setup() {
        accumulator = new LongMinAccumulator();
    }

    @After
    public void tearDown() {
        accumulator = null;
    }

    @Test(expected = IllegalStateException.class)
    public void none() {
        assertThat(accumulator.result(), is(0L));
    }

    @Test
    public void minAccumulatorWorks() {
        for(Integer i : ImmutableList.of(1, 2, -1, 3, 4)) {
            accumulator.accumulate(i.longValue());
        }
        assertThat(accumulator.result(), is(-1L));
    }


    @Test
    public void overrideDefault() {
        assertThat(new LongMinAccumulator(5L).result(), is(5L));

        accumulator = new LongMinAccumulator(1L);
        accumulator.accumulate(2L);
        assertThat(accumulator.result(), is(1L));
    }

    @Test
    public void defaultValue() {
        assertThat(new LongMinAccumulator(-1L).result(), is(-1L));
    }
}
