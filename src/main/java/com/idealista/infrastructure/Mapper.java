package com.idealista.infrastructure;

import com.idealista.infrastructure.api.viewmodel.PublicAd;
import com.idealista.infrastructure.api.viewmodel.QualityAd;
import com.idealista.infrastructure.model.AdVO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public QualityAd convertToQualityAd(AdVO entity) {
        QualityAd viewModel = new QualityAd();
        viewModel.setId(entity.getId());
        viewModel.setTypology(entity.getTypology());
        viewModel.setDescription(entity.getDescription());
        viewModel.setPictureUrls(entity.getPictures());
        viewModel.setHouseSize(entity.getHouseSize());
        viewModel.setGardenSize(entity.getGardenSize());
        viewModel.setScore(entity.getScore());
        viewModel.setIrrelevantSince(entity.getIrrelevantSince());

        return viewModel;
    }

    public PublicAd convertToAd(AdVO entity) {
        PublicAd viewModel = new PublicAd();
        viewModel.setId(entity.getId());
        viewModel.setTypology(entity.getTypology());
        viewModel.setDescription(entity.getDescription());
        viewModel.setPictureUrls(entity.getPictures());
        viewModel.setHouseSize(entity.getHouseSize());
        viewModel.setGardenSize(entity.getGardenSize());

        return viewModel;
    }

}
