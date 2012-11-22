package com.chrisgray.accumulators.core;

public interface Accumulator<From, To> {
    void accumulate(From value);
    To result();
}