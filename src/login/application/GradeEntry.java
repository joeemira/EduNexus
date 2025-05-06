package login.application;




class GradeEntry {
    private String courseName;
    private float grade;

    public GradeEntry(String courseName, float grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    public String getCourseName() { return courseName; }
    public float getGrade() { return grade; }
}
