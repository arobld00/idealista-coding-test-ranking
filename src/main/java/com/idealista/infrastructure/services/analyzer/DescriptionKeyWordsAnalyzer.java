package com.idealista.infrastructure.services.analyzer;

import java.util.Arrays;
import java.util.List;

class DescriptionKeyWordsAnalyzer extends Analyzer {

    private static final Integer KEYWORD_SCORE = 5;

    private List<String> KEY_WORDS;

    public DescriptionKeyWordsAnalyzer(Analyzer analyzer) {
        super(analyzer);
        KEY_WORDS =  Arrays.asList("luminoso", "nuevo", "céntrico", "reformado", "ático");
    }

    @Override
    public void execute(ScoreStatistics scoreStatistics) {
        if (scoreStatistics.hasDescription()) {
            long total = KEY_WORDS.stream()
                    .filter(scoreStatistics.getDescription().toLowerCase()::contains)
                    .count();
            scoreStatistics.updateScore(Math.toIntExact(total * DescriptionKeyWordsAnalyzer.KEYWORD_SCORE));
        }
        nextAnalyzer.execute(scoreStatistics);
    }

}
