package me.victar.bootquery.model;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

/**
 * Created by viktor.kadol on 01.02.16.
 */
public class ResultWrapper {

    String path;

    public ResultWrapper(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
