package me.victar.bootquery.controller;

import me.victar.bootquery.model.ResultWrapper;
import me.victar.bootquery.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jcr.RepositoryException;
import java.util.List;


/**
 * Created by viktor.kadol on 01.02.16.
 */
@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ResultWrapper> find(@RequestParam(name = "s") String searchTerm) throws RepositoryException {
        return searchService.search(searchTerm);
    }
}
