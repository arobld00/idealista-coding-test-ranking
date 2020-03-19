package com.idealista.infrastructure.services.pictures;

public class SDPictureScore extends PictureScore {

    private static final Integer SD_SCORE = 10;

    @Override
    public Integer getScore() {
        return SDPictureScore.SD_SCORE;
    }

}
