package com.ing.lu.data;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 *
 */
public class SessionFactoryProvider {

    /**
     * @param resource
     * @param properties
     * @param mapperFiles
     * @return
     */
    public SqlSessionFactory produceFactory(final String resource, final Properties properties, final List<String> mapperFiles) {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException("Fatal Error.  Cause: " + e, e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
        for (String mapperFile : mapperFiles) {
            InputStream in = getClass().getClassLoader().getResourceAsStream(mapperFile);
            Configuration configuration = sqlSessionFactory.getConfiguration();
            if (in != null) {
                XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(in, configuration, mapperFile, configuration.getSqlFragments());
                xmlMapperBuilder.parse();
            } else {
                System.err.println("Error file not loaded " + mapperFile);
            }
        }
        return sqlSessionFactory;
    }
}
