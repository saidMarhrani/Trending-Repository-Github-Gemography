package com.gemography.trendingreposfromgithub.feignclient;

import com.gemography.trendingreposfromgithub.dto.GithubRepositoryPaginationResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "github-trending-repo-api", url = "${trending.repo.github.api}")
@Headers({"Content-Type: application/json"})
public interface GitHubFeignClient {

    @GetMapping(value = "?q=created:>{date}&sort=stars&order=desc&per_page=100")
    GithubRepositoryPaginationResponse getTheMost100TrendingRepoInTheLastMonth(@PathVariable("date") String date);

}
