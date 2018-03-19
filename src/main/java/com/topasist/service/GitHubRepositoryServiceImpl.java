package com.topasist.service;

import com.topasist.dto.GitHubRepositoryDetailsDto;
import com.topasist.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GitHubRepositoryServiceImpl implements GitHubRepositoryService {

    private final RestTemplate restTemplate;

    private String GITHUB_REPOSITORY_DETAILS_URL = "https://api.github.com/repos/";

    @Override
    public GitHubRepositoryDetailsDto getRepositoryDetails(String owner, String repositoryName, Locale locale) {

        GitHubRepositoryDetailsDto result = restTemplate
                .getForObject(GITHUB_REPOSITORY_DETAILS_URL + owner + "/" + repositoryName, GitHubRepositoryDetailsDto.class);

        result.setCreatedAt(DateUtils.convertDateToLocaleFormat(result.getCreatedAt(), locale));

        return restTemplate
                .getForObject(GITHUB_REPOSITORY_DETAILS_URL + owner + "/" + repositoryName, GitHubRepositoryDetailsDto.class);
    }
}
