package me.victar.bootquery.jcr.impl;

import me.victar.bootquery.jcr.NodeType;
import me.victar.bootquery.jcr.SearchCriteria;
import org.junit.Test;

import javax.jcr.query.Query;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by viktor.kadol on 01.02.16.
 */
public class SearchJCRSQL2ImplTest {

    @Test
    public void testGetQuery() throws Exception {
        SearchJCRSQL2Impl searchJCRSQL2  =new SearchJCRSQL2Impl(NodeType.BASE,
                Arrays.asList(new SearchCriteriaContains("Geometrixx"), new SearchCriteriaDescendant("/content/geometrixx")));
        assertEquals("SELECT * FROM [nt:base] AS s WHERE CONTAINS(s.*,'Geometrixx') and ISDESCENDANTNODE([/content/geometrixx])",searchJCRSQL2.getQuery());
    }

    @Test
    public void testGetQueryType() throws Exception {
        SearchJCRSQL2Impl searchJCRSQL2  =new SearchJCRSQL2Impl(NodeType.BASE,  Arrays.asList(new SearchCriteriaContains("Geometrixx")));
        assertEquals(Query.JCR_SQL2, searchJCRSQL2.getQueryType());
    }
}