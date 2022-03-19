/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.generic;

/**
 *
 * @author m07er
 */
public class GenericsSinif {

    private String name;
    private String surname;
    private Integer age;
    private Integer birthDay;

    //Constructor with parameter
    public GenericsSinif(String name, String surname, Integer age, Integer birthDay) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.birthDay = birthDay;
    }

    public void FullName() {

    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

}
