package com.ing.lu.data;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
* Created by lp501 on 01/12/2016.
*/
public abstract class MyBatis implements MyBatisCredentials {
    private static Logger logger = LoggerFactory.getLogger(MyBatis.class);
    private SqlSessionFactory sessionFactory;

    /**
     *
     * @param mapperFiles
     * @throws IOException
     */
    protected void initialize(final List<String> mapperFiles) throws Exception {
        sessionFactory = null;
        SqlSession session = null;
        try {
            Properties properties = new Properties();
            properties.setProperty("username", getConnectionUser());
            properties.setProperty("password", new String(getConnectionPassword()));
            properties.setProperty("connectString", getConnectionString());
            sessionFactory = (new SessionFactoryProvider()).produceFactory(getResourceFile(), properties, mapperFiles);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sessionFactory;
    }
}

