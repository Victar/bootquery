package me.victar.bootquery.jcr;

/**
 * Created by viktor.kadol on 28.01.16.
 */
public enum NodeType {

    BASE("nt:base");

    private final String id;

    private NodeType(String id){
        this.id = id;
    }

    public String getExpression(){
        return id;
    }

}
