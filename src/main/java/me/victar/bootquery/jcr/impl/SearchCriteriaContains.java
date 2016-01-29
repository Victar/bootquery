package me.victar.bootquery.jcr.impl;

import me.victar.bootquery.jcr.SearchCriteria;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.groovy.util.StringUtil;

/**
 * Created by viktor.kadol on 29.01.16.
 */
public class SearchCriteriaContains implements SearchCriteria {

    String text;

    public SearchCriteriaContains(String text) {
        this.text = text;
    }

    @Override
    public String getQuery() {
        if (StringUtils.isEmpty(text)){
            return "";
        }
        return String.format("CONTAINS(s.*,'%s')", text);
    }
}
