package com.ivangarcia.studentmanagementsystem;

public class StudentResponseDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String course;
    private String yearLevel;
    private String email;

    public StudentResponseDTO() {
    }

    public StudentResponseDTO(Integer id,
                              String firstName,
                              String lastName,
                              String course,
                              String yearLevel,
                              String email) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.course = course;
        this.yearLevel = yearLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
