package com.idealista.infrastructure.services.scoring;

import com.idealista.infrastructure.Mapper;
import com.idealista.infrastructure.model.AdVO;
import com.idealista.infrastructure.persistence.AdRepository;
import com.idealista.infrastructure.services.AdService;
import com.idealista.infrastructure.services.analyzer.ScoreAnalyzer;
import com.idealista.infrastructure.services.analyzer.ScoreStatistics;
import com.idealista.infrastructure.utils.errors.IncorrectScoringException;
import org.springframework.stereotype.Service;

@Service
public class ScoreAdServiceImpl extends AdService implements ScoreAdService {

    public ScoreAdServiceImpl(AdRepository adRepository, Mapper mapper) {
        super(adRepository, mapper);
    }

    @Override
    public void execute() {
        try {
            for(AdVO ad : adRepository.findAll()) {
                ScoreAnalyzer.instance().execute(new ScoreStatistics(ad));
                adRepository.save(ad);
            }
        } catch (Exception e) {
            throw new IncorrectScoringException("Some error ocurred : ", e.getCause());
        }
    }

}
