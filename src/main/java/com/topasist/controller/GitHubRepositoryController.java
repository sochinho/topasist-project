package com.topasist.controller;

import com.topasist.dto.GitHubRepositoryDetailsDto;
import com.topasist.service.GitHubRepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping("/repositories")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GitHubRepositoryController {

    private final GitHubRepositoryService gitHubRepositoryService;

    @GetMapping(value = "/{owner}/{repository-name}")
    public ResponseEntity<GitHubRepositoryDetailsDto> getPublicationsByExpertId(@Valid @PathVariable("owner") String owner,
                                                                                @Valid @PathVariable("repository-name") String repositoryName,
                                                                                Locale locale) {
        return ResponseEntity.ok(gitHubRepositoryService.getRepositoryDetails(owner, repositoryName, locale));
    }

}
