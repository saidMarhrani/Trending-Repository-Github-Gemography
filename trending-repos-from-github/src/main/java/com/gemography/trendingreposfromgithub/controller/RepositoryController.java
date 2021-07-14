package com.gemography.trendingreposfromgithub.controller;

import com.gemography.trendingreposfromgithub.dto.Repository;
import com.gemography.trendingreposfromgithub.service.TrendingRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/repos")
@RequiredArgsConstructor
public class RepositoryController {

    private final TrendingRepositoryService trendingRepositoryService;

    @GetMapping
    public List<Repository> getRepos() {
        return this.trendingRepositoryService.getRepositories();
    }

    @GetMapping("/lang/count")
    public Map<String, Integer> getNumberOfRepositoriesByLang(){
        return this.trendingRepositoryService.getNumberOfRepositoriesPerLanguage();
    }

    @GetMapping("/lang/{lang}")
    public List<Repository> getListOfReposByLanguage(@PathVariable(name = "lang") String language){
        return this.trendingRepositoryService.getListOfRepositoriesPerLanguage(language);
    }

}
