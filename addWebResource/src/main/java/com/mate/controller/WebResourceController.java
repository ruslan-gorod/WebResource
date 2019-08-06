package com.mate.controller;

import com.mate.model.WebResource;
import com.mate.service.WebResourceService;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebResourceController {

    @Autowired
    private WebResourceService webResourceService;

    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView mw) {
        List<WebResource> resources = webResourceService.getAll()
                .orElseGet(Collections::emptyList);
        mw.addObject("resources", resources);
        mw.setViewName("resources");
        return mw;
    }

    @RequestMapping(value = "/add-resource", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView mw) {
        mw.addObject("resource", new WebResource());
        mw.setViewName("add-resource");
        return mw;
    }

    @RequestMapping(value = "/add-resource", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute WebResource resource, ModelAndView mw) {
        webResourceService.create(resource);
        List<WebResource> resources = webResourceService.getAll()
                .orElseGet(Collections::emptyList);
        mw.addObject("resources", resources);
        mw.setViewName("resources");
        return mw;
    }

    @RequestMapping(value = "delete-resource", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("r_id") Long id, ModelAndView mw) {
        webResourceService.delete(id);
        List<WebResource> resources = webResourceService.getAll()
                .orElseGet(Collections::emptyList);
        mw.addObject("resources", resources);
        mw.setViewName("resources");
        return mw;
    }
}
