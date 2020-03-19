package com.idealista.infrastructure.services.analyzer;

class DescriptionAnalyzer extends Analyzer {

    public DescriptionAnalyzer(Analyzer analyzer) {
        super(analyzer);
    }

    @Override
    public void execute(ScoreStatistics scoreStatistics) {
        if (scoreStatistics.hasDescription()) {
            scoreStatistics.updateScore(scoreStatistics.getDescriptionScore());
        }
        nextAnalyzer.execute(scoreStatistics);
    }

}
