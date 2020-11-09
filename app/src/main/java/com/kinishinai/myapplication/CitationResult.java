package com.kinishinai.myapplication;

public class CitationResult {
    private String workCited;
    private String workCited2;
    private String bookTitle;
    private String inTextCited;

    public CitationResult(String workCited, String workCited2, String inTextCited, String bookTitle){
        this.workCited = workCited;
        this.workCited2 = workCited2;
        this.inTextCited = inTextCited;
        this.bookTitle = bookTitle;
    }

    public String getWorkCited2() {
        return workCited2;
    }

    public void setWorkCited2(String workCited2) {
        this.workCited2 = workCited2;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getWorkCited() {
        return workCited;
    }

    public void setWorkCited(String workCited) {
        this.workCited = workCited;
    }

    public String getInTextCited() {
        return inTextCited;
    }

    public void setInTextCited(String inTextCited) {
        this.inTextCited = inTextCited;
    }
}
