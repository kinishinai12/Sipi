package com.kinishinai.myapplication;

import java.io.Serializable;

public class EditorNameDynamically implements Serializable {
    private String editorFirstname;
    private String editorLastName;

    public EditorNameDynamically(){}

    public EditorNameDynamically(String editorFirstname, String editorLastName) {
        this.editorFirstname = editorFirstname;
        this.editorLastName = editorLastName;
    }

    public String getEditorFirstname() {
        return editorFirstname;
    }

    public void setEditorFirstname(String editorFirstname) {
        this.editorFirstname = editorFirstname;
    }

    public String getEditorLastName() {
        return editorLastName;
    }

    public void setEditorLastName(String editorLastName) {
        this.editorLastName = editorLastName;
    }
}
