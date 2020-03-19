package com.idealista.infrastructure.services.analyzer;

abstract  class Analyzer {

    protected Analyzer nextAnalyzer;

    public Analyzer(Analyzer nextAnalyzer) {
        this.nextAnalyzer = nextAnalyzer;
    }

    public abstract void execute(ScoreStatistics scoreStatistics);

}
