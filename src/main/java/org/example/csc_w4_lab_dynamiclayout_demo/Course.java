package org.example.csc_w4_lab_dynamiclayout_demo;

public class Course {
    private String iconURL;

    @Override
    public String toString() {
        return "Course{" +
                "iconURL='" + iconURL + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                '}';
    }

    public Course(String iconURL, String courseCode, String courseTitle) {
        this.iconURL = iconURL;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    private String courseCode;
    private String courseTitle;
}


