package me.victar.bootquery.service;

import me.victar.bootquery.jcr.NodeType;
import me.victar.bootquery.jcr.Search;
import me.victar.bootquery.jcr.impl.SearchCriteriaContains;
import me.victar.bootquery.jcr.impl.SearchCriteriaDescendant;
import me.victar.bootquery.jcr.impl.SearchJCRSQL2Impl;
import me.victar.bootquery.model.ResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.Arrays;
import java.util.List;

/**
 * Created by viktor.kadol on 02.02.16.
 */
@Component
public class SearchService {

    @Autowired
    private JCRUtil jcrUtil;

    public List<ResultWrapper> search(String search) throws RepositoryException {
        Session session = jcrUtil.getSession();
        Search searchJCRSQL2 = new SearchJCRSQL2Impl(NodeType.BASE,
                Arrays.asList(new SearchCriteriaContains(search), new SearchCriteriaDescendant("/content/geometrixx")));
        List<ResultWrapper> results = jcrUtil.getResults(session, searchJCRSQL2);
        jcrUtil.closeAndSaveSession(session);
        return results;
    }
}
