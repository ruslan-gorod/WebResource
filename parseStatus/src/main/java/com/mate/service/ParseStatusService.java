package com.mate.service;

import com.mate.model.WebResource;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ParseStatusService {

    @Autowired
    private WebResourceService webResourceService;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void createWebResourcesWithStatusesAndDurations() {
        List<WebResource> webResources = webResourceService.findAll().orElseGet(Collections::emptyList);
        webResources.stream()
                .map(webResource -> saveStatusToDb(webResource))
                .forEach(w -> webResourceService.save(w));
    }

    private WebResource saveStatusToDb(WebResource webResource) {
        URI uriResource = URI.create(webResource.getUrl());
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uriResource, HttpMethod.GET, entity, String.class);
        String statusCode = responseEntity.getStatusCode().toString();
        webResource.setStatus(statusCode);
        return webResource;
    }
}
