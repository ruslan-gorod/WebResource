package com.mate.service;

import com.mate.model.WebResource;
import java.util.List;
import java.util.Optional;

public interface WebResourceService {

    Optional<List<WebResource>> getAll();

    Optional<WebResource> create(WebResource webResource);

    void delete(Long id);

}
