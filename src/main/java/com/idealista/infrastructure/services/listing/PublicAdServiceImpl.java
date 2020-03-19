package com.idealista.infrastructure.services.listing;

import com.idealista.infrastructure.Mapper;
import com.idealista.infrastructure.api.viewmodel.PublicAd;
import com.idealista.infrastructure.persistence.AdRepository;
import com.idealista.infrastructure.services.AdService;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PublicAdServiceImpl extends AdService implements PublicAdService {

    public PublicAdServiceImpl(AdRepository adRepository, Mapper mapper) {
        super(adRepository, mapper);
    }

    @Override
    public List<PublicAd> find() {
        Sort sort = Sort.by(Sort.Direction.DESC, "score");
        return this.adRepository.findAllByRelevantScore(AdService.RELEVANT_SCORE, sort).stream()
                .map(ad -> this.mapper.convertToAd(ad))
                .collect(Collectors.toList());
    }

}
