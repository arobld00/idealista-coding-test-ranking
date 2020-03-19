package com.idealista.infrastructure.model;

import com.idealista.infrastructure.services.pictures.PictureScore;

public class PictureVO {

    private String url;

    private PictureScore pictureScore;

    public PictureVO(String url, PictureScore pictureScore) {
        this.url = url;
        this.pictureScore = pictureScore;
    }

    public PictureVO() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getScore() {
        return pictureScore.getScore();
    }

}