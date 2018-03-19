package com.topasist.controller;

import com.topasist.TopAsistApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TopAsistApplicationTests.class)
@Slf4j
public class GitHubRepositoryControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Autowired
    private RestTemplate restTemplate;

    private String correctOwner = "githubtraining", incorrectOwner = "githubtraining3121";
    private String correctRepository = "example-submodule", incorrectRepository = "example-submodule32142";

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void when_FindOwnerRepository_Then_ReturnOk() throws Exception {

        String expectedFullName = "githubtraining/example-submodule";
        String expectedDescription = "This repository contains several commits of a single project file as a simple example used in conjunction with submodules.";
        String expectedCloneUrl = "https://github.com/githubtraining/example-submodule.git";
        Integer expectedStars = 2;
        String expectedCreatedAt = "2013-08-05T17:15:38Z";

        mockMvc.perform(
                get("/repositories/{owner}/{repository-name}", correctOwner, correctRepository)
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.fullName", is(expectedFullName)))
                .andExpect(jsonPath("$.description", is(expectedDescription)))
                .andExpect(jsonPath("$.cloneUrl", is(expectedCloneUrl)))
                .andExpect(jsonPath("$.stars", is(expectedStars)))
                .andExpect(jsonPath("$.createdAt", is(expectedCreatedAt)));
    }

    @Test
    public void when_FindOwnerRepository_Then_ReturnNotFound() throws Exception {

        mockMvc.perform(
                get("/repositories/{owner}/{repository-name}", incorrectOwner, incorrectRepository)
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNotFound());
    }
}
