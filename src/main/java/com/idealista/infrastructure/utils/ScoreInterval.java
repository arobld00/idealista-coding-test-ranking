package com.idealista.infrastructure.utils;

public class ScoreInterval {

    private ClosedInterval interval;

    private Integer points;

    public ScoreInterval(ClosedInterval interval, Integer points) {
        this.interval = interval;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public boolean includes(Integer points) {
        return interval.includes(points);
    }

}
