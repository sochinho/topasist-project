package com.topasist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class GitHubRepositoryDetailsDto {

    @NotNull
    private String fullName;

    private String description;

    @NotNull
    private String cloneUrl;

    @NotNull
    @Range(min = 0, max = 5)
    private Integer stars;

    private String createdAt;

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("cloneUrl")
    public String getCloneUrl() {
        return cloneUrl;
    }

    @JsonProperty("clone_url")
    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("stars")
    public Integer getStars() {
        return stars;
    }

    @JsonProperty("stargazers_count")
    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
