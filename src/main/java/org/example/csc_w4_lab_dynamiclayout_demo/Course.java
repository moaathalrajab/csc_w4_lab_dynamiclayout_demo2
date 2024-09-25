package org.example.csc_w4_lab_dynamiclayout_demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Moaath Alrajab
 *
 * The Course class is a simple POJO class that represents a course in the application.
 * It has three fields: iconURL, courseCode, and courseTitle.
 * The iconURL is a string that holds the URL of the course's icon.
 * The courseCode is a string that holds the course code, and the courseTitle is a string that holds the course title.
 * The class has a constructor that initializes the three fields, and it also has getters and setters for the three
 * fields.
 * The class also has a toString method that returns a string representation of the course object.
 * The class is used in the MainController class to represent a course in the application.
 */

public class Course {
    private StringProperty iconURL =new SimpleStringProperty(this, "icnURL","/imgs/face.png");
    private StringProperty courseCode = new SimpleStringProperty(this, "crsCode","CSC000");
    private StringProperty courseTitle = new SimpleStringProperty(this, "crsTitle","Default Name");

    public Course(String iconURL, String courseCode, String courseTitle) {
        this.iconURL = new SimpleStringProperty(this, "icnURL",iconURL);;
        this.courseCode = new SimpleStringProperty(this, "crsCode",courseCode);;
        this.courseTitle = new SimpleStringProperty(this, "crsTitle",courseTitle);;
    }




    public String getIconURL() {
        return iconURL.get();
    }

    public StringProperty iconURLProperty() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL.set(iconURL);
    }

    public String getCourseCode() {
        return courseCode.get();
    }

    public StringProperty courseCodeProperty() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode.set(courseCode);
    }

    public String getCourseTitle() {
        return courseTitle.get();
    }

    public StringProperty courseTitleProperty() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle.set(courseTitle);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseTitle=" + getCourseTitle() +
                ", courseCode=" + getCourseCode() +
                ", iconURL=" + getIconURL() +
                '}';
    }
}


