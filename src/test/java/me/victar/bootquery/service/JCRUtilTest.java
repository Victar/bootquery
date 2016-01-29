package me.victar.bootquery.service;

import org.junit.Before;
import org.junit.Test;

import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by viktor.kadol on 27.01.16.
 */
public class JCRUtilTest {

    private JCRUtil jcrUtil;

    @Before
    public void setup(){
        jcrUtil  =new JCRUtil();
    }

    @Test
    public void test_session_created() throws RepositoryException{
        Session session = jcrUtil.getSession(" http://localhost:4502/crx/server", "admin", "admin");
        assertNotNull(session);
    }
    @Test
    public void test_session_closed() throws RepositoryException {
        Session session = jcrUtil.getSession(" http://localhost:4502/crx/server", "admin", "admin");
        assertNotNull(session);
        assertTrue(session.isLive());
        jcrUtil.closeAndSaveSession(session);
        assertFalse(session.isLive());
    }

    @Test
    public void test_get_node_properties() throws RepositoryException {
        Session session = jcrUtil.getSession(" http://localhost:4502/crx/server", "admin", "admin");
        List<Property> result =  jcrUtil.getNodeProperties(session, "/content/aemexam");
        assertNotNull(result);
        assertEquals(3, result.size());

    }
}