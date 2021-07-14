package com.gemography.trendingreposfromgithub.service;

import com.gemography.trendingreposfromgithub.dto.GithubRepositoryPaginationResponse;
import com.gemography.trendingreposfromgithub.dto.Repository;
import com.gemography.trendingreposfromgithub.feignclient.GitHubFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrendingRepositoryService {

    private final GitHubFeignClient gitHubFeignClient;

    public List<Repository> getRepositories() {

        LocalDate localDate = LocalDate.of(LocalDate.now().getYear(), returnLastMonth(), LocalDate.now().getDayOfMonth());
        GithubRepositoryPaginationResponse githubRepositoryPaginationResponse = gitHubFeignClient.getTheMost100TrendingRepoInTheLastMonth(localDate.toString());
        return githubRepositoryPaginationResponse.getItems();
    }

    public Set<String> getLanguages(List<Repository> repositories){
        return repositories.stream().map(Repository::getLanguage).collect(Collectors.toSet());
    }

    public Map<String, Integer> getNumberOfRepositoriesPerLanguage(){
        List<Repository> repositories = getRepositories();
        return getLanguages(repositories).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(language -> language, lang -> getNumberOfRepositoriesByLanguage(repositories, lang)));
    }

    public List<Repository> getListOfRepositoriesPerLanguage(String language){
        List<Repository> repositories = getRepositories();
        return this.getRepositoriesByLanguage(repositories, language);
    }

    private int getNumberOfRepositoriesByLanguage(List<Repository> repositories, String language){
        return this.getRepositoriesByLanguage(repositories, language).size();
    }

    private List<Repository> getRepositoriesByLanguage(List<Repository> repositories, String language){
        return repositories
                .stream()
                .filter(repository -> repository.getLanguage() != null && repository.getLanguage().equals(language))
                .collect(Collectors.toList());
    }

    private int returnLastMonth(){
        return (LocalDate.now().getMonth().getValue() - 1 >= 0) ? (LocalDate.now().getMonth().getValue() - 1) : 12;
    }

}
