package org.example;

public class Word {

    private int id;
    private int grade;
    private  String name;
    private  String meaning;

    public Word(){}

    public Word(int id, int grade, String name, String meaning) {
        this.id = id;
        this.grade = grade;
        this.name = name;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
