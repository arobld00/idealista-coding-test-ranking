package com.idealista.infrastructure.services.analyzer;

import com.idealista.infrastructure.model.PictureVO;

class PictureAnalyzer extends Analyzer {

    private static final Integer NO_PICTURE_SCORE = -10;

    public PictureAnalyzer(Analyzer analyzer) {
        super(analyzer);
    }

    @Override
    public void execute(ScoreStatistics scoreStatistics) {
        if (scoreStatistics.hasPicture()) {
            for (PictureVO picture : scoreStatistics.getPictures()) {
                scoreStatistics.updateScore(picture.getScore());
            }
        } else {
            scoreStatistics.updateScore(PictureAnalyzer.NO_PICTURE_SCORE);
        }
        nextAnalyzer.execute(scoreStatistics);
    }

}
