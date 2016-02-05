package me.victar.bootquery.jcr.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by viktor.kadol on 29.01.16.
 */
public class SearchCriteriaDescendantTest {

    @Test
    public void testCriteria(){
        SearchCriteriaDescendant searchCriteriaDescendant = new SearchCriteriaDescendant("/content");
        assertEquals("ISDESCENDANTNODE([/content])", searchCriteriaDescendant.getQuery());
    }

    @Test
    public void testCriteriaEmpty(){
        SearchCriteriaDescendant searchCriteriaDescendant = new SearchCriteriaDescendant("");
        assertEquals("", searchCriteriaDescendant.getQuery());
    }

}