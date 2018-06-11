package com.ing.lu.data;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lionel on 30/12/16.
 */
public interface MyMapper {
    public List<Person> selectPerson() throws Exception;


    public Person SELECT_1_PERSON(@Param(value = "firstname") String firstname);

}
