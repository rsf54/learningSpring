package com.ryanfah.ec.explorecali.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class TourRating {

    @Id
    private String id;
    private String tourId;
    @NotNull
    private Integer customerId;
    @Min(0)
    @Max(5)
    private Integer score;
    @Size(max=255)
    private String comment;

    protected TourRating(){}

    public TourRating(Integer score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
