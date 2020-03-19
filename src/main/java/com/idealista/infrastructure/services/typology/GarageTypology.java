package com.idealista.infrastructure.services.typology;

import com.idealista.infrastructure.model.AdVO;

public class GarageTypology extends HouseTypology implements Complete {

    @Override
    public boolean execute(AdVO ad) {
        return ad.hasPicture();
    }

}
