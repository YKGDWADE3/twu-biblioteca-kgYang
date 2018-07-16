package com.twu.biblioteca.model;

public class Movie {
    private Integer id;

    private String name;

    private Integer year;

    private String director;

    private Integer rate;

    private Boolean isAvavilable;

    public Movie(Integer id, String name, Integer year, String director, Integer rate, Boolean isAvavilable) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
        this.isAvavilable = isAvavilable;
    }

    public Movie(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Boolean getAvavilable() {
        return isAvavilable;
    }

    public void setAvavilable(Boolean avavilable) {
        isAvavilable = avavilable;
    }

    public void printInfo() {
        System.out.print(name + ", " + year + ", " + director  + ", " + rate + ".\n");
    }
}
