package com.idealista.infrastructure.services.typology;

import com.idealista.infrastructure.model.AdVO;
import com.idealista.infrastructure.services.analyzer.ScoreStatistics;

public class GarageTypology extends HouseTypology implements Complete {

    @Override
    public boolean execute(AdVO ad) {
        return ad.hasPicture();
    }

    @Override
    public Integer accept(ScoreStatistics scoreStatistics) {
        return scoreStatistics.visit(this);
    }

}
