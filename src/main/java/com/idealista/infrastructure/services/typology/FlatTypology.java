package com.idealista.infrastructure.services.typology;

import com.idealista.infrastructure.model.AdVO;
import com.idealista.infrastructure.utils.ClosedInterval;
import com.idealista.infrastructure.utils.ScoreInterval;

public class FlatTypology extends TypologyScore {

    private static final Integer MIN_INTERVAL_FLAT = 20;

    private static final Integer MAX_INTERVAL_FLAT = 49;

    private static final Integer FLAT_POINTS = 10;

    private static final Integer BEST_MIN_INTERVAL_FLAT = 50;

    private static final Integer BEST_FLAT_POINTS = 30;

    private static final ScoreInterval CLOSED_INTERVAL = new ScoreInterval(new ClosedInterval(
            FlatTypology.MIN_INTERVAL_FLAT,
            FlatTypology.MAX_INTERVAL_FLAT),
            FlatTypology.FLAT_POINTS);

    private static final ScoreInterval FINITE_INTERVAL = new ScoreInterval(new ClosedInterval(
            FlatTypology.BEST_MIN_INTERVAL_FLAT,
            TypologyScore.MAX_VALUE),
            FlatTypology.BEST_FLAT_POINTS);

    @Override
    public boolean execute(AdVO ad) {
        return ad.hasHouseSize();
    }

    @Override
    public Integer getScoreByWords(Integer words) {
        if (FlatTypology.FINITE_INTERVAL.includes(words)) {
            return FlatTypology.FINITE_INTERVAL.getPoints();
        }
        if (FlatTypology.CLOSED_INTERVAL.includes(words)) {
            return FlatTypology.CLOSED_INTERVAL.getPoints();
        }
        return TypologyScore.DEFAULT_SCORE;
    }

}
