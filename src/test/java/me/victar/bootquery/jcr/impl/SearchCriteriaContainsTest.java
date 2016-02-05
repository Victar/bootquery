package me.victar.bootquery.jcr.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by viktor.kadol on 29.01.16.
 */
public class SearchCriteriaContainsTest {

    @Test
    public void testCriteria(){
        SearchCriteriaContains searchCriteriaContains = new SearchCriteriaContains("any");
        assertEquals("CONTAINS(s.*,'any')", searchCriteriaContains.getQuery());
    }

    @Test
    public void testCriteriaEmpty(){
        SearchCriteriaContains searchCriteriaContains = new SearchCriteriaContains("");
        assertEquals("", searchCriteriaContains.getQuery());
    }

}