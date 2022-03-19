/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.uygulama2;

import java.util.List;

/**
 *
 * @author m07er
 */
public class Author {

    //Fields
    private long authorIdentifier;
    private String authorName;
    private String authorSurname;
    private int authorAge;
    private boolean authorGender;
    List<Books> listBook;

    //Constructor
    public Author() {
    }

    //Constructor with parameters
    public Author(long authorIdentifier, String authorName, String authorSurname, int authorAge, boolean authorGender) {
        this.authorIdentifier = authorIdentifier;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.authorAge = authorAge;
        this.authorGender = authorGender;
    }

    public String FullName() {
        String fullName = this.authorName + " " + this.authorSurname;
        return fullName;
    }

    public String Gender() {
        String gender = null;
        if (this.authorGender == true) {
            gender = "Erkek";
        } else if (this.authorGender == false) {
            gender = "Kadın";
        } else {
            gender = "Böyle bir durumla ilk defa karşılaşıyorum.";
        }
        return gender;
    }

    //Getter and Setter
    public long getAuthorIdentifier() {
        return authorIdentifier;
    }

    public void setAuthorIdentifier(long authorIdentifier) {
        this.authorIdentifier = authorIdentifier;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public int getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
    }

    public boolean isAuthorGender() {
        return authorGender;
    }

    public void setAuthorGender(boolean authorGender) {
        this.authorGender = authorGender;
    }

    public List<Books> getListBook() {
        return listBook;
    }

    public void setListBook(List<Books> listBook) {
        this.listBook = listBook;
    }

}
