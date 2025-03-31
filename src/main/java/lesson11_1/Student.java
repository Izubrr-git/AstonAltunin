package lesson11_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String group;
    private int course;
    private HashMap<String, List<Integer>> grades = new HashMap<>();

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void addGrade(String subject, int grade) {
        grades.putIfAbsent(subject, new ArrayList<>());
        grades.get(subject).add(grade);
    }

    public void addGradesForSubjects(Map<String, Integer> subjectsAndGrades) {
        subjectsAndGrades.forEach(this::addGrade);
    }

    public List<Integer> getGrades(String subject) {
        return grades.get(subject);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        int count = 0;

        for (List<Integer> subjectGrades : grades.values()) {
            for (Integer grade : subjectGrades) {
                sum += grade;
                count++;
            }
        }

        return count > 0 ? (double) sum / count : 0.0;
    }
}