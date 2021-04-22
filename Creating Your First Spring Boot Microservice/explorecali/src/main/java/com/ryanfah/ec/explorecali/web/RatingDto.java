package com.ryanfah.ec.explorecali.web;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class RatingDto {

    @Min(0)
    @Max(5)
    private Integer score;

    @Size(max=255)
    private String comment;

    @NotNull
    private Integer customerId;

    public RatingDto(Integer score, String comment, Integer customerId) {
        this.score = score;
        this.comment = comment;
        this.customerId = customerId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public Integer getScore() {
        return this.score;
    }

    public String getComment() {
        return this.comment;
    }
}
