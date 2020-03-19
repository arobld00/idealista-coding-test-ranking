package com.idealista.infrastructure.services.analyzer;

import java.util.Date;

class IrrelevantAnalyzer extends Analyzer {

    private static final Integer IRRELEVANT_SCORE = 40;

    public IrrelevantAnalyzer(Analyzer analyzer) {
        super(analyzer);
    }

    public IrrelevantAnalyzer(){
        this(null);
    }

    @Override
    public void execute(ScoreStatistics scoreStatistics) {
        if (scoreStatistics.isIrrelevant() < IrrelevantAnalyzer.IRRELEVANT_SCORE) {
            scoreStatistics.setIrrelevantAd(new Date());
        }
    }

}
