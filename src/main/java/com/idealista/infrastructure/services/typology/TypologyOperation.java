package com.idealista.infrastructure.services.typology;

import com.idealista.infrastructure.model.AdVO;

public abstract class TypologyOperation {

    public abstract Integer getScore(String description);

    public boolean isComplete(AdVO ad) {
        return ad.hasPicture() && this.execute(ad);
    }

    public abstract boolean execute(AdVO ad);

}
