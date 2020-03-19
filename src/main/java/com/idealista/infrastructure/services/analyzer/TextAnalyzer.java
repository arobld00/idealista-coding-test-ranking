package com.idealista.infrastructure.services.analyzer;

class TextAnalyzer extends Analyzer {

    private static final Integer TEXT_SCORE = 5;

    public TextAnalyzer(Analyzer analyzer){
        super(analyzer);
    }

    @Override
    public void execute(ScoreStatistics scoreStatistics) {
        if (scoreStatistics.hasDescription()) {
            scoreStatistics.updateScore(TextAnalyzer.TEXT_SCORE);
        }
        nextAnalyzer.execute(scoreStatistics);
    }

}
