package com.kinishinai.myapplication;

import java.io.Serializable;

public class AuthorNameDynamically implements Serializable {
    private String authorFirstname;
    private String authorLastName;


    public AuthorNameDynamically(){}

    public AuthorNameDynamically(String authorFirstname, String authorLastName) {
        this.authorFirstname = authorFirstname;
        this.authorLastName = authorLastName;
    }

    public String getAuthorFirstname() {
        return authorFirstname;
    }

    public void setAuthorFirstname(String authorFirstname) {
        this.authorFirstname = authorFirstname;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
}
