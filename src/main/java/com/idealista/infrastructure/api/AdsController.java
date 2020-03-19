package com.idealista.infrastructure.api;

import java.util.*;

import com.idealista.infrastructure.api.viewmodel.PublicAd;
import com.idealista.infrastructure.api.viewmodel.QualityAd;
import com.idealista.infrastructure.services.listing.PublicAdService;
import com.idealista.infrastructure.services.listing.QualityAdService;
import com.idealista.infrastructure.services.scoring.ScoreAdService;
import com.idealista.infrastructure.utils.errors.IncorrectScoringException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AdsController {

    private ScoreAdService adScoring;

    private PublicAdService publicAdListing;

    private QualityAdService qualityAdListing;

    public AdsController(ScoreAdService adScoring, PublicAdService publicAdListing, QualityAdService qualityAdListing) {
        this.adScoring = adScoring;
        this.publicAdListing = publicAdListing;
        this.qualityAdListing = qualityAdListing;
    }

    //.antMatchers("/admin/*").hasRole("ADMIN");
    @GetMapping("/admin/ads")
    public ResponseEntity<List<QualityAd>> qualityListing() {
        List<QualityAd> qualityList = this.qualityAdListing.find();
        if (qualityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(qualityList, HttpStatus.OK);
    }

    @GetMapping("/ads")
    public ResponseEntity<List<PublicAd>> publicListing() {
        List<PublicAd> publicList = this.publicAdListing.find();
        if (publicList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(publicList, HttpStatus.OK);
    }

    @PostMapping("/ads/calculate")
    public ResponseEntity<Void> calculateScore() {
        try {
            adScoring.execute();
            return ResponseEntity.noContent().build();
        } catch (IncorrectScoringException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot be completed scoring", e);
        }
    }

}
