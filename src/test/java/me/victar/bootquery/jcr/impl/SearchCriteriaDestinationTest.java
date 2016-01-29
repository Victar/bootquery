package me.victar.bootquery.jcr.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by viktor.kadol on 29.01.16.
 */
public class SearchCriteriaDestinationTest {

    @Test
    public void test_criteria(){
        SearchCriteriaDestination searchCriteriaDestination = new SearchCriteriaDestination("/content");
        assertEquals("ISDESCENDANTNODE([/content])", searchCriteriaDestination.getQuery());
    }

    @Test
    public void test_criteria_empty(){
        SearchCriteriaDestination searchCriteriaDestination = new SearchCriteriaDestination("");
        assertEquals("", searchCriteriaDestination.getQuery());
    }

}