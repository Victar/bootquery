package me.victar.bootquery.jcr.impl;

import me.victar.bootquery.jcr.NodeType;
import me.victar.bootquery.jcr.Search;
import me.victar.bootquery.jcr.SearchCriteria;

import javax.jcr.query.Query;
import java.util.List;

/**
 * Created by viktor.kadol on 28.01.16.
 */
public class SearchJCRSQL2Impl implements Search {

    NodeType nodeType;

    List<SearchCriteria> searchCriterias;

    public SearchJCRSQL2Impl(NodeType nodeType, List<SearchCriteria> searchCriterias) {
        this.nodeType = nodeType;
        this.searchCriterias = searchCriterias;
    }

    @Override
    public String getQuery() {
        StringBuilder query = new StringBuilder("");
        query.append("SELECT * FROM [");
        query.append(nodeType.getExpression());
        query.append("] AS a WHERE");
        searchCriterias.forEach(searchCriteria -> query.append(searchCriteria.getQuery()).append(" "));
        return query.toString();
    }

    @Override
    public String getQueryType() {
        return Query.JCR_SQL2;
    }
}
