##Sum

Currently supports primitive longs and doubles

    LongAccumulator sum = new LongSumAccumulator();
    sum.accumulate(5L);
    sum.accumulate(6L);
    sum.result(); //11L

    DoubleAccumulator sum = new DoubleSumAccumulator();
    sum.accumulate(5.0);
    sum.accumulate(6.1);
    sum.result(); //11.1