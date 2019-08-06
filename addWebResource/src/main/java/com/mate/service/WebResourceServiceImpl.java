package com.mate.service;

import com.mate.dao.WebResourceRepository;
import com.mate.model.WebResource;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebResourceServiceImpl implements WebResourceService {

    @Autowired
    private WebResourceRepository webResourceRepository;
    @Override
    public Optional<List<WebResource>> getAll() {
        return Optional.of(webResourceRepository.findAll());
    }

    @Override
    public Optional<WebResource> create(WebResource webResource) {
        return Optional.of(webResourceRepository.save(webResource));
    }

    @Override
    public void delete(Long id) {
        webResourceRepository.deleteById(id);
    }
}
