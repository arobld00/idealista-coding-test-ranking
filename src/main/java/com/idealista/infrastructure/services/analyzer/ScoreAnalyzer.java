package com.idealista.infrastructure.services.analyzer;

public class ScoreAnalyzer {

    private static ScoreAnalyzer gambleAnalyzer;

    public static ScoreAnalyzer instance() {
        if (gambleAnalyzer == null) {
            gambleAnalyzer = new ScoreAnalyzer();
        }
        return gambleAnalyzer;
    }

    private Analyzer analyzer;

    public ScoreAnalyzer() {
        analyzer = new TextAnalyzer(
                new PictureAnalyzer(
                new DescriptionAnalyzer(
                new DescriptionKeyWordsAnalyzer(
                new CompleteAdAnalyzer(
                new IrrelevantAnalyzer())))));
    }

    public void execute(ScoreStatistics scoreStatistics) {
        analyzer.execute(scoreStatistics);
    }

}
