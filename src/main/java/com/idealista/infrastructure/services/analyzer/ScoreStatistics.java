package com.idealista.infrastructure.services.analyzer;

import com.idealista.infrastructure.services.typology.GarageTypology;
import com.idealista.infrastructure.services.typology.HouseTypology;
import com.idealista.infrastructure.services.typology.TypologyScore;
import com.idealista.infrastructure.utils.ClosedInterval;
import com.idealista.infrastructure.model.AdVO;
import com.idealista.infrastructure.model.PictureVO;

import java.util.Collection;
import java.util.Date;

public class ScoreStatistics {

    private static final Integer MIN_SCORE = 0;

    private static final Integer MAX_SCORE = 100;

    private static final ClosedInterval RATE_INTERVAL = new ClosedInterval(
            ScoreStatistics.MIN_SCORE,
            ScoreStatistics.MAX_SCORE);

    private static final Integer DEFAULT_SCORE = 0;

    private HouseTypology typology;

    private AdVO adVO;

    private Integer score;

    public ScoreStatistics(AdVO adVO) {
        assert adVO != null;
        this.adVO = adVO;
        typology = adVO.getTypology();
        score = ScoreStatistics.DEFAULT_SCORE;
    }

    public void updateScore(Integer score) {
        this.score += score;
    }

    public AdVO getAdVO() {
        return this.adVO;
    }

    public String getDescription() {
        return adVO.getDescription();
    }

    public Integer isIrrelevant() {
        return adVO.getScore();
    }

    public void setIrrelevantAd(Date irrelevantSince) {
        adVO.setIrrelevantSince(irrelevantSince);
    }

    public Collection<PictureVO> getPictures() {
        return adVO.getPictures();
    }

    public boolean isComplete() {
        return typology.isComplete(adVO);
    }

    public boolean hasDescription() {
        return adVO.hasDescription();
    }

    public boolean hasPicture() {
        return adVO.hasPicture();
    }

    public void adjustScore() {
        setScore(Math.max(this.score, ScoreStatistics.RATE_INTERVAL.getMin()));
        setScore(Math.min(this.score, ScoreStatistics.RATE_INTERVAL.getMax()));
        adVO.setScore(score);
    }

    private void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDescriptionScore() {
        return typology.accept(this);
    }

    public Integer visit(TypologyScore typologyScore) {
        return typologyScore.getScore(adVO.getDescription());
    }

    public Integer visit(GarageTypology garageTypology) {
        return ScoreStatistics.DEFAULT_SCORE;
    }

}
