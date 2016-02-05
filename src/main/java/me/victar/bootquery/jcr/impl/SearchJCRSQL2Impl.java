package me.victar.bootquery.jcr.impl;

import me.victar.bootquery.jcr.NodeType;
import me.victar.bootquery.jcr.Search;
import me.victar.bootquery.jcr.SearchCriteria;

import javax.jcr.query.Query;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by viktor.kadol on 28.01.16.
 */
public class SearchJCRSQL2Impl implements Search {

    NodeType nodeType;

    List<SearchCriteria> searchCriterias;

    public static class Builder{

        NodeType nodeType;
        SearchCriteriaDescendant searchCriteriaDescendant;
        SearchCriteriaContains searchCriteriaContains;

        public Builder setDescendant(String path){
            searchCriteriaDescendant = new SearchCriteriaDescendant(path);
            return this;
        };

        public Builder setContains(String search){
            searchCriteriaContains = new SearchCriteriaContains(search);
            return this;
        };

        public Builder setNodeType(NodeType nType){
            nodeType  = nType;
            return this;
        }

        SearchJCRSQL2Impl build(){
            return new SearchJCRSQL2Impl(this);
        }

    }
    public SearchJCRSQL2Impl(Builder builder){
        searchCriterias = Arrays.asList(builder.searchCriteriaContains, builder.searchCriteriaDescendant);
        nodeType = builder.nodeType;
    }

    public SearchJCRSQL2Impl(NodeType nodeType, List<SearchCriteria> searchCriterias) {
        this.nodeType = nodeType;
        this.searchCriterias = searchCriterias;
    }

    @Override
    public String getQuery() {
        StringBuilder query = new StringBuilder("");
        query.append("SELECT * FROM [");
        query.append(nodeType.getExpression());
        query.append("] AS s WHERE ");
        AtomicInteger atomicInteger = new AtomicInteger(0);
        searchCriterias.forEach(searchCriteria ->
            query.append(searchCriteria.getQuery())
                        .append(atomicInteger.getAndIncrement()>= searchCriterias.size()-1 ? "" : " and "));
        return query.toString();
    }

    @Override
    public String getQueryType() {
        return Query.JCR_SQL2;
    }
}
