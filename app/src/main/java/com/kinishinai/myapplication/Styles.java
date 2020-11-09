package com.kinishinai.myapplication;

public class Styles {
    private int id;
    private String citationStyle;
    private String source;
    private String version;
    private int imageStyle;

    public Styles(int id, String citationStyle, String source, String version, int imageStyle){
        this.id = id;
        this.citationStyle = citationStyle;
        this.source = source;
        this.version = version;
        this.imageStyle = imageStyle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCitationStyle() {
        return citationStyle;
    }

    public void setCitationStyle(String citationStyle) {
        this.citationStyle = citationStyle;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getImageStyle() {
        return imageStyle;
    }

    public void setImageStyle(int imageStyle) {
        this.imageStyle = imageStyle;
    }
}
