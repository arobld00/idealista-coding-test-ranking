package com.idealista.infrastructure.services.typology;

import com.idealista.infrastructure.model.AdVO;
import com.idealista.infrastructure.utils.WordCounter;

public abstract class TypologyScore extends HouseTypology implements Scoring, Complete {

    protected static final Integer DEFAULT_SCORE = 0;

    protected static final Integer MAX_VALUE = Integer.MAX_VALUE;

    @Override
    public boolean isComplete(AdVO ad) {
        return ad.hasDescription() && this.execute(ad);
    }

    public Integer getScore(String description) {
        WordCounter wordCounter = new WordCounter(description);
        return this.getScoreByWords(wordCounter.getCount());
    }

    public abstract Integer getScoreByWords(Integer words);

}
