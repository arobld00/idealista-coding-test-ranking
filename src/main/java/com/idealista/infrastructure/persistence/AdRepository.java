package com.idealista.infrastructure.persistence;

import com.idealista.infrastructure.model.AdVO;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AdRepository extends MongoRepository<AdVO, String> {

    @Query("{'score' : {$lt : ?0}}")
    Collection<AdVO> findAllByIrrelevantScore(Integer score, Sort sort);

    @Query("{'score' : {$gte : ?0}}")
    Collection<AdVO> findAllByRelevantScore(Integer score, Sort sort);

}