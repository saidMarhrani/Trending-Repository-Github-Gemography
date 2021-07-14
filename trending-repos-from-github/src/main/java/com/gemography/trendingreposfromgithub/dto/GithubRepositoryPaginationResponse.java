package com.gemography.trendingreposfromgithub.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepositoryPaginationResponse {

    @JsonProperty("total_count")
    private String totalCount;
    @JsonProperty("incomplete_results")
    private String incompleteResults;

    @JsonProperty("items")
    private List<Repository> items;

}
