package com.idealista.infrastructure.services.typology;

import com.idealista.infrastructure.model.AdVO;
import com.idealista.infrastructure.services.analyzer.ScoreStatistics;

public abstract class HouseTypology {

    public boolean isComplete(AdVO ad) {
        return ad.hasPicture() && this.execute(ad);
    }

    public abstract boolean execute(AdVO ad);

    public abstract Integer accept(ScoreStatistics scoreStatistics);

}
