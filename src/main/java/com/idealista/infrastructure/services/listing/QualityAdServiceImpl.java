package com.idealista.infrastructure.services.listing;

import com.idealista.infrastructure.Mapper;
import com.idealista.infrastructure.api.viewmodel.QualityAd;
import com.idealista.infrastructure.persistence.AdRepository;
import com.idealista.infrastructure.services.AdService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QualityAdServiceImpl extends AdService implements QualityAdService {

    public QualityAdServiceImpl(AdRepository adRepository, Mapper mapper) {
        super(adRepository, mapper);
    }

    @Override
    public List<QualityAd> find() {
        Sort sort = Sort.by(Sort.Direction.DESC, "irrelevantSince");
        return this.adRepository.findAllByIrrelevantScore(AdService.RELEVANT_SCORE, sort).stream()
                .map(ad -> this.mapper.convertToQualityAd(ad))
                .collect(Collectors.toList());
    }

}
