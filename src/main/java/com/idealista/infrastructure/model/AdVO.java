package com.idealista.infrastructure.model;

import com.idealista.infrastructure.services.typology.HouseTypology;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Document(collection = "advos")
public class AdVO {

    @Id
    private String id;

    private HouseTypology typology;

    private String description;

    private List<PictureVO> pictures = new ArrayList<>();

    private Integer houseSize;

    private Integer gardenSize;

    private Integer score;

    private Date irrelevantSince;

    public AdVO(HouseTypology typology,
                String description,
                List<PictureVO> pictures,
                Integer houseSize,
                Integer gardenSize,
                Integer score,
                Date irrelevantSince) {
        this.typology = typology;
        this.description = description;
        this.houseSize = houseSize;
        this.gardenSize = gardenSize;
        this.score = score;
        this.irrelevantSince = irrelevantSince;
        if (pictures != null) {
            this.pictures = pictures;
        }
    }

    public AdVO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTypology(HouseTypology typology) {
        this.typology = typology;
    }

    public HouseTypology getTypology() {
        return this.typology;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PictureVO> getPictures() {
        return pictures;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getIrrelevantSince() {
        return irrelevantSince;
    }

    public void setIrrelevantSince(Date irrelevantSince) {
        this.irrelevantSince = irrelevantSince;
    }

    public boolean hasDescription() {
        return isNotBlank(this.getDescription());
    }

    public boolean hasPicture() {
        return isNotEmpty(this.getPictures());
    }

    public boolean hasHouseSize() {
        return this.houseSize != null;
    }

    public boolean hasGardenSize() {
        return this.gardenSize != null;
    }

}
