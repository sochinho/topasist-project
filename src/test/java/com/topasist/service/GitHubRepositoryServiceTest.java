package com.topasist.service;

import com.topasist.dto.GitHubRepositoryDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@Slf4j
public class GitHubRepositoryServiceTest {

    private GitHubRepositoryService gitHubRepositoryService;

    @Mock
    private RestTemplate restTemplate;

    private Locale locale;

    private final String GITHUB_REPOSITORY_DETAILS_URL = "https://api.github.com/repos/";
    private final String correctOwner = "correctOwner", correctOwner2 = "correctOwner2", incorrectOwner = "incorrectOwner";
    private final String correctRepository = "correctRepository", correctRepository2 = "correctRepository2", incorrectRepository = "incorrectRepository";
    private GitHubRepositoryDetailsDto gitHubRepositoryDetailsDto1, gitHubRepositoryDetailsDto2;

    @Before
    public void setUp() {

        gitHubRepositoryService = new GitHubRepositoryServiceImpl(restTemplate);

        locale = Locale.getDefault();

        String fullName1 = "fullName1", fullName2 = "fullName2";
        String description1 = "description1", description2 = "description2";
        String cloneUrl1 = "cloneUrl1", cloneUrl2 = "cloneUrl2";
        Integer stars1 = 1, stars2 = 2;
        String createdAt1 = "2017-10-05T11:48:21Z", createdAt2 = "2017-10-07T11:48:21Z";

        gitHubRepositoryDetailsDto1 = new GitHubRepositoryDetailsDto();
        gitHubRepositoryDetailsDto1.setFullName(fullName1);
        gitHubRepositoryDetailsDto1.setDescription(description1);
        gitHubRepositoryDetailsDto1.setCloneUrl(cloneUrl1);
        gitHubRepositoryDetailsDto1.setCreatedAt(createdAt1);
        gitHubRepositoryDetailsDto1.setStars(stars1);

        gitHubRepositoryDetailsDto2 = new GitHubRepositoryDetailsDto();
        gitHubRepositoryDetailsDto2.setFullName(fullName2);
        gitHubRepositoryDetailsDto2.setDescription(description2);
        gitHubRepositoryDetailsDto2.setCloneUrl(cloneUrl2);
        gitHubRepositoryDetailsDto2.setStars(stars2);
        gitHubRepositoryDetailsDto2.setCreatedAt(createdAt2);

        when(restTemplate.getForObject(GITHUB_REPOSITORY_DETAILS_URL + correctOwner + "/" + correctRepository, GitHubRepositoryDetailsDto.class))
                .thenReturn(gitHubRepositoryDetailsDto1);
        when(restTemplate.getForObject(GITHUB_REPOSITORY_DETAILS_URL + correctOwner2 + "/" + correctRepository2, GitHubRepositoryDetailsDto.class))
                .thenReturn(gitHubRepositoryDetailsDto2);
    }

    @Test
    public void testFindOwnerRepositoryByNames() {
        GitHubRepositoryDetailsDto result = gitHubRepositoryService.getRepositoryDetails(correctOwner, correctRepository, locale);

        assertEquals(gitHubRepositoryDetailsDto1.getFullName(), result.getFullName());
        assertEquals(gitHubRepositoryDetailsDto1.getCloneUrl(), result.getCloneUrl());
        assertEquals(gitHubRepositoryDetailsDto1.getDescription(), result.getDescription());
        assertEquals(gitHubRepositoryDetailsDto1.getStars(), result.getStars());
        assertEquals(gitHubRepositoryDetailsDto1.getCreatedAt(), result.getCreatedAt());

        GitHubRepositoryDetailsDto result2 = gitHubRepositoryService.getRepositoryDetails(correctOwner2, correctRepository2, locale);

        assertEquals(gitHubRepositoryDetailsDto2.getFullName(), result2.getFullName());
        assertEquals(gitHubRepositoryDetailsDto2.getCloneUrl(), result2.getCloneUrl());
        assertEquals(gitHubRepositoryDetailsDto2.getDescription(), result2.getDescription());
        assertEquals(gitHubRepositoryDetailsDto2.getStars(), result2.getStars());
        assertEquals(gitHubRepositoryDetailsDto2.getCreatedAt(), result2.getCreatedAt());
    }
}
