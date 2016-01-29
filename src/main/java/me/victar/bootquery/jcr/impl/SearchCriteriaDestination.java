package me.victar.bootquery.jcr.impl;

import me.victar.bootquery.jcr.SearchCriteria;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by viktor.kadol on 29.01.16.
 */
public class SearchCriteriaDestination implements SearchCriteria{

    private String path;

    public SearchCriteriaDestination(String path) {
        this.path = path;
    }

    @Override
    public String getQuery() {
        if (StringUtils.isEmpty(path)){
            return "";
        }
        return String.format("ISDESCENDANTNODE([%s])", path);
    }
}
