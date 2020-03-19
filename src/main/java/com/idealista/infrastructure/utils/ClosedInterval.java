package com.idealista.infrastructure.utils;

public class ClosedInterval {

    private Integer min;

    private Integer max;

    public ClosedInterval(Integer min, Integer max) {
        assert min <= max;
        this.min = min;
        this.max = max;
    }

    public boolean includes(Integer value) {
        return min <= value && value <= max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

}
