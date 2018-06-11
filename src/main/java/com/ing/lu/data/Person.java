package com.ing.lu.data;

/**
 * Created by lionel on 30/12/16.
 */
public class Person {
    private String name;
    private String firstname;
    private String born;
    private String lastname;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    @Override
    public String toString() {
        return "com.ing.lu.Person{" +
                "name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", born='" + born + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
