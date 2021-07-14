package com.gemography.trendingreposfromgithub.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

    private Long id;
    @JsonProperty("node_id")
    private String nodeId;
    private String name;

    @JsonProperty("full_name")
    private String fullName;
    private Boolean fork;

    @JsonProperty("commits_url")
    private String commitsUrl;

    @JsonProperty("contents_url")
    private String contentsUrl;

    private String language;

}
