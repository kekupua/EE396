package org.tensorflow.demo.env;


public class Room {
    private String CourseNum;
    private String CourseTitle;
    private String CourseInstr;
    private String CourseDay;
    private String CourseTime;
    private String CourseLoc;

    public Room(String courseNum, String courseTitle, String courseInstr, String courseDay, String courseTime, String courseLoc) {
        CourseNum = courseNum;
        CourseTitle = courseTitle;
        CourseInstr = courseInstr;
        CourseDay = courseDay;
        CourseTime = courseTime;
        CourseLoc = courseLoc;
    }

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

    @Override
    public String toString() {
        return "Room{" +
                "CourseNum='" + CourseNum + '\'' +
                ", CourseTitle='" + CourseTitle + '\'' +
                ", CourseInstr='" + CourseInstr + '\'' +
                ", CourseDay='" + CourseDay + '\'' +
                ", CourseTime='" + CourseTime + '\'' +
                ", CourseLoc='" + CourseLoc + '\'' +
                '}';
    }
}
