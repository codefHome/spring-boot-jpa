package com.springbootjpa.springbootjpa.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="course_id", nullable = false)
    private Long courseId;
    @Basic
    @Column(name="course_name", nullable = false, length = 45)
    private String courseName;
    @Basic
    @Column(name="course_duration", nullable = false, length = 43)
    private String courseDuration;
    @Basic
    @Column(name="course_description", nullable = false, length = 100)
    private String courseDescription;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="instructor_id", referencedColumnName = "instructor_id",nullable = false)
    private Instructor instructor;

    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name="enrolled_in", joinColumns = {@JoinColumn(name="course_id")},
    inverseJoinColumns = {@JoinColumn(name="student_id")})
    private Set<Student> students =new HashSet<>();


public Course() {
    }

public Course(String courseName, String courseDuration, String courseDescription, Instructor instructor) {
    this.courseName = courseName;
    this.courseDuration = courseDuration;
    this.courseDescription = courseDescription;
    this.instructor = instructor;
}

public void assignStudentToCourse(Student student){
    this.students.add(student);
    student.getCourses().add(this);
}

public void removeStudentFromCourse(Student student){
    this.students.remove(student);
    student.getCourses().remove(this);
}


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
        result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
        result = prime * result + ((courseDuration == null) ? 0 : courseDuration.hashCode());
        result = prime * result + ((courseDescription == null) ? 0 : courseDescription.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (courseId == null) {
            if (other.courseId != null)
                return false;
        } else if (!courseId.equals(other.courseId))
            return false;
        if (courseName == null) {
            if (other.courseName != null)
                return false;
        } else if (!courseName.equals(other.courseName))
            return false;
        if (courseDuration == null) {
            if (other.courseDuration != null)
                return false;
        } else if (!courseDuration.equals(other.courseDuration))
            return false;
        if (courseDescription == null) {
            if (other.courseDescription != null)
                return false;
        } else if (!courseDescription.equals(other.courseDescription))
            return false;
        return true;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
                + ", courseDescription=" + courseDescription + "]";
    }

    
}
