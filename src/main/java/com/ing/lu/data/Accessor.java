package com.ing.lu.data;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lionel on 30/12/16.
 */
public class Accessor implements MyMapper {
    private static Logger logger = LoggerFactory.getLogger(Accessor.class);

    private MyBatisNeo4j myBatisNeo4j;

    public Accessor() throws Exception {
        List<String> mappers = new ArrayList<>();
        mappers.add("MyMapper.xml");
        myBatisNeo4j = new MyBatisNeo4j(mappers);
    }

    public static void main(String[] args) {
        try {
            Accessor accessor = new Accessor();
           // Person person = accessor.SELECT_1_PERSON("Blake");

            List<com.ing.lu.data.Person> personList = accessor.selectPerson();
            for (com.ing.lu.data.Person person : personList) {
                logger.info(person.getName() + " " + person.getBorn());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public Person SELECT_1_PERSON(String firstname) {
        Person person = null;
        try (SqlSession sqlSession = myBatisNeo4j.getSqlSessionFactory().openSession()) {
            MyMapper myMapper = sqlSession.getMapper(MyMapper.class);
            person = myMapper.SELECT_1_PERSON(firstname);
            logger.info(person.toString());

            person = myMapper.SELECT_1_PERSON("Libby");
            logger.info(person.toString());

        }
        return person;
    }

    @Override
    public List<Person> selectPerson() throws Exception {
        List<Person> personList = null;
        try (SqlSession sqlSession = myBatisNeo4j.getSqlSessionFactory().openSession()) {
            MyMapper myMapper = sqlSession.getMapper(MyMapper.class);
            personList = myMapper.selectPerson();
        }
        return personList;
    }


}
