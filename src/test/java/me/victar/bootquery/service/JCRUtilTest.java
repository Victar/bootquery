package me.victar.bootquery.service;

import me.victar.bootquery.jcr.NodeType;
import me.victar.bootquery.jcr.impl.SearchCriteriaContains;
import me.victar.bootquery.jcr.impl.SearchCriteriaDescendant;
import me.victar.bootquery.jcr.impl.SearchJCRSQL2Impl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.QueryResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by viktor.kadol on 27.01.16.
 */
@Ignore
public class JCRUtilTest {

    private JCRUtil jcrUtil;

    @Before
    public void setup() {
        jcrUtil = new JCRUtil();
    }

    @Test
    public void testGetSessionCreated() throws RepositoryException {
        Session session = jcrUtil.getSession(" http://localhost:4502/crx/server", "admin", "admin");
        assertNotNull(session);
    }

    @Test
    public void testCloseAndSaveSession() throws RepositoryException {
        Session session = jcrUtil.getSession(" http://localhost:4502/crx/server", "admin", "admin");
        assertNotNull(session);
        assertTrue(session.isLive());
        jcrUtil.closeAndSaveSession(session);
        assertFalse(session.isLive());
    }

    @Test
    public void testGetNodeProperties() throws RepositoryException {
        Session session = jcrUtil.getSession(" http://localhost:4502/crx/server", "admin", "admin");
        List<Property> result = jcrUtil.getNodeProperties(session, "/content/aemexam");
        assertNotNull(result);
        assertEquals(3, result.size());

    }

    @Test
    public void testRunQuery() throws RepositoryException {
        Session session = jcrUtil.getSession("http://localhost:4502/crx/server", "admin", "admin");
        SearchJCRSQL2Impl searchJCRSQL2  =new SearchJCRSQL2Impl(NodeType.BASE,
                Arrays.asList(new SearchCriteriaContains("Geometrixx"), new SearchCriteriaDescendant("/content/geometrixx")));
        QueryResult queryResult = jcrUtil.runQuery(session, searchJCRSQL2);
        assertNotNull(queryResult);

    }
}