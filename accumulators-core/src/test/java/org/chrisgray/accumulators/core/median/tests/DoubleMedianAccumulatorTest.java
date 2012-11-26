package org.chrisgray.accumulators.core.median.tests;

import com.google.common.collect.ImmutableList;
import org.chrisgray.accumulators.core.median.MedianAccumulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DoubleMedianAccumulatorTest {
    protected MedianAccumulator<Double> accumulator;

    @Before
    public void setup() {
        accumulator = new MedianAccumulator<Double>();
    }

    @After
    public void tearDown() {
        accumulator = null;
    }

    @Test
    public void none() {
        assertThat(accumulator.result(), is(0.0));
    }

    @Test
    public void one() {
        accumulator.accumulate(1.1);
        assertThat(accumulator.result(), is(1.1));
    }

    @Test
    public void evenNumberOfEltsAverages() {
        final ImmutableList<Integer> list = ImmutableList.of(1, 2, 3, 4);
        for(Integer i : list) {
            accumulator.accumulate(i.doubleValue());
        }
        assertThat(accumulator.result(), is(2.5));
    }

    @Test
    public void oddNumberOfElts() {
        final ImmutableList<Integer> items = ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for(Integer i : items) {
            accumulator.accumulate(i.doubleValue());
        }
        assertThat(accumulator.result(), is(5.0));
    }
}
