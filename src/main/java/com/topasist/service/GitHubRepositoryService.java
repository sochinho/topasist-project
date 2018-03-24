package com.topasist.service;

import com.topasist.dto.GitHubRepositoryDetailsDto;

import java.util.Locale;

public interface GitHubRepositoryService {

    /**
     * @param owner
     * @param repositoryName
     * @return
     */
    GitHubRepositoryDetailsDto getRepositoryDetails(String owner, String repositoryName, Locale locale);

}
