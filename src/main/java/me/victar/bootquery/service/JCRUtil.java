package me.victar.bootquery.service;


import me.victar.bootquery.jcr.Search;
import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.*;
import javax.jcr.nodetype.PropertyDefinition;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by viktor.kadol on 27.01.16.
 */
public class JCRUtil {

    public static String DEFAULT_WORKSPACENAME = "crx.default";

    public Session getSession(String url, String username, String password) throws RepositoryException {
        return getSession(url, username, password, DEFAULT_WORKSPACENAME);
    }

    public Session getSession(String url, String username, String password, String workspace) throws RepositoryException {
        Repository repository = JcrUtils.getRepository(url);
        SimpleCredentials credentials = new SimpleCredentials(username, password == null ? new char[0] : password.toCharArray());
        Session session = repository.login(credentials, workspace);
        return session;
    }

    public void closeAndSaveSession(Session session) {
        try {
            if (session != null && session.isLive()) {
                session.save();
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        finally {
            if (session != null && session.isLive()) {
                session.logout();
            }
        }
    }

    public List<Property> getNodeProperties(Session session, String nodePath) throws RepositoryException {
        Node node  = session.getNode(nodePath);
        List<Property> result = new ArrayList<>();
        if (node!=null){
            PropertyIterator it = node.getProperties();
            while(it.hasNext()){
                result.add(it.nextProperty());
            }
        }
        return result;
    }

    public QueryResult runQuery(Session session, Search search) throws RepositoryException {
        QueryManager queryManager = session.getWorkspace().getQueryManager();
        Query query = queryManager.createQuery(search.getQuery(), search.getQueryType());
        QueryResult queryResult = query.execute();
        return queryResult;
    }

}
