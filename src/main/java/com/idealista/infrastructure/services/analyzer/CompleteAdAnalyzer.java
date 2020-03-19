package com.idealista.infrastructure.services.analyzer;

class CompleteAdAnalyzer extends Analyzer {

    private static final Integer COMPLETE_SCORE = 40;

    public CompleteAdAnalyzer(Analyzer analyzer) {
        super(analyzer);
    }

    @Override
    public void execute(ScoreStatistics scoreStatistics) {
        if (scoreStatistics.isComplete()) {
            scoreStatistics.updateScore(CompleteAdAnalyzer.COMPLETE_SCORE);
        }
        scoreStatistics.adjustScore();
        nextAnalyzer.execute(scoreStatistics);
    }

}
