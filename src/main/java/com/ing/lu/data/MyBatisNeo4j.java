package com.ing.lu.data;

import java.util.List;

/**
 * Created by ld153 on 26/03/2015.
 */
public class MyBatisNeo4j extends MyBatis implements MyBatisCredentials {


    public MyBatisNeo4j(List<String> mapperFiles) throws Exception {
        initialize(mapperFiles);
    }


    @Override
    public String getResourceFile() {
        return "mybatis-config-neo4j.xml";
    }

    @Override
    public String getConnectionUser() {
        return System.getProperty("jdbc.neo4j.user");
    }

    @Override
    public char[] getConnectionPassword() {
        return System.getProperty("jdbc.neo4j.password").toCharArray();
    }

    @Override
    public String getConnectionString() {
        return System.getProperty("jdbc.neo4j.connectString");
    }
}
