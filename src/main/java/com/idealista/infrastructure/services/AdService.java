package com.idealista.infrastructure.services;

import com.idealista.infrastructure.Mapper;
import com.idealista.infrastructure.persistence.AdRepository;

public class AdService {

    protected static final Integer RELEVANT_SCORE = 40;

    protected AdRepository adRepository;

    protected Mapper mapper;

    public AdService(AdRepository adRepository, Mapper mapper) {
        this.adRepository = adRepository;
        this.mapper = mapper;
    }

}
