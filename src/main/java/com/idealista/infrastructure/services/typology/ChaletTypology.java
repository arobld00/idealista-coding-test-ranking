package com.idealista.infrastructure.services.typology;

import com.idealista.infrastructure.model.AdVO;
import com.idealista.infrastructure.utils.ClosedInterval;
import com.idealista.infrastructure.utils.ScoreInterval;

public class ChaletTypology extends TypologyScore {

    private static final Integer MIN_INTERVAL_CHALET = 51;

    private static final Integer CHALET_POINTS = 20;

    private static final ScoreInterval FINITE_INTERVAL = new ScoreInterval(new ClosedInterval(
            ChaletTypology.MIN_INTERVAL_CHALET,
            TypologyScore.MAX_VALUE),
            ChaletTypology.CHALET_POINTS);

    @Override
    public boolean execute(AdVO ad) {
        return ad.hasGardenSize() && ad.hasHouseSize();
    }

    @Override
    public Integer getScoreByWords(Integer words) {
        if (ChaletTypology.FINITE_INTERVAL.includes(words)) {
            return ChaletTypology.FINITE_INTERVAL.getPoints();
        }
        return TypologyScore.DEFAULT_SCORE;
    }

}
