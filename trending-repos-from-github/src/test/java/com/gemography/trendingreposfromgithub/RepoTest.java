package com.gemography.trendingreposfromgithub;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemography.trendingreposfromgithub.dto.GithubRepositoryPaginationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class RepoTest {

    @Test
    void test() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        GithubRepositoryPaginationResponse githubRepositoryPaginationResponse = mapper.readValue(jsonInput(), GithubRepositoryPaginationResponse.class);

        System.out.println(githubRepositoryPaginationResponse.getItems().size());

    }

    public String jsonInput() throws IOException {
        File file = ResourceUtils.getFile("classpath:repos.json");
        return new String(Files.readAllBytes(file.toPath()));
    }

}
