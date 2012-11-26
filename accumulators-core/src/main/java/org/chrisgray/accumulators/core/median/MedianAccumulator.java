package org.chrisgray.accumulators.core.median;

import org.chrisgray.accumulators.core.mean.MeanAccumulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianAccumulator<E extends Number & Comparable<E>> {
    private final List<E> list = new ArrayList<E>();
    private boolean dirty = false;

    public void accumulate(E value) {
        list.add(value);
        dirty = true;
    }

    public double result() {
        if (dirty) {
            Collections.sort(list);
            dirty = false;
        }

        switch (list.size()) {
            case 0: return 0;
            case 1: return list.get(0).doubleValue();
        }

        if (isEven(list.size())) {
            final MeanAccumulator meanAcc = new MeanAccumulator();
            meanAcc.accumulate(list.get(list.size() / 2).doubleValue());
            meanAcc.accumulate(list.get((list.size() - 1) / 2).doubleValue());
            return meanAcc.result();
        }
        else
            return list.get(medianIndexIfOdd()).doubleValue();
    }

    private static boolean isEven(int value) {
        return (value % 2) == 0;
    }

    private int medianIndexIfOdd() {
        return (list.size() - 1) / 2;
    }
}
