package com.mate.service;

import com.mate.model.WebResource;
import java.util.List;
import java.util.Optional;

public interface WebResourceService {

    Optional<WebResource> save(WebResource webResource);

    Optional<List<WebResource>> findAll();
}
