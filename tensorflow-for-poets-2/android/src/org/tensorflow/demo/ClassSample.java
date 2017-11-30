package org.tensorflow.demo;

/**
 * Created by Ky on 11/14/2017.
 */

class ClassSample {
    private String CourseNum;
    private String CourseTitle;
    private String CourseInstr;
    private String CourseDay;
    private String CourseTime;
    private String CourseLoc;

    public String getCourseNum() {
        return CourseNum;
    }

    public void setCourseNum(String courseNum) {
        CourseNum = courseNum;
    }

    public String getCourseTitle() {
        return CourseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        CourseTitle = courseTitle;
    }

    public String getCourseInstr() {
        return CourseInstr;
    }

    public void setCourseInstr(String courseInstr) {
        CourseInstr = courseInstr;
    }

    public String getCourseDay() {
        return CourseDay;
    }

    public void setCourseDay(String courseDay) {
        CourseDay = courseDay;
    }

    public String getCourseTime() {
        return CourseTime;
    }

    public void setCourseTime(String courseTime) {
        CourseTime = courseTime;
    }

    public String getCourseLoc() {
        return CourseLoc;
    }

    public void setCourseLoc(String courseLoc) {
        CourseLoc = courseLoc;
    }
}
