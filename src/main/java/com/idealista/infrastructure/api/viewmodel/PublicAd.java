package com.idealista.infrastructure.api.viewmodel;

import com.idealista.infrastructure.model.PictureVO;
import com.idealista.infrastructure.services.typology.HouseTypology;

import java.util.List;

public class PublicAd {

    private String id;

    private HouseTypology typology;

    private String description;

    private List<PictureVO> pictureUrls;

    private Integer houseSize;

    private Integer gardenSize;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HouseTypology getTypology() {
        return typology;
    }

    public void setTypology(HouseTypology typology) {
        this.typology = typology;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PictureVO> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<PictureVO> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public Integer getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(Integer houseSize) {
        this.houseSize = houseSize;
    }

    public Integer getGardenSize() {
        return gardenSize;
    }

    public void setGardenSize(Integer gardenSize) {
        this.gardenSize = gardenSize;
    }

}
