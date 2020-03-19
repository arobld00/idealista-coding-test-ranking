package com.idealista.infrastructure.services.pictures;

public class HDPictureScore extends PictureScore {

    private static final Integer HD_SCORE = 20;

    @Override
    public Integer getScore() {
        return HDPictureScore.HD_SCORE;
    }

}