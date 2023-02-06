package com.springbootjpa.springbootjpa.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="instructor_id", nullable = false)
    private Long instructorId;
    @Basic
    @Column(name="first_name",nullable=false, length=45)
    private String firstName;
    @Basic
    @Column(name="last_name",nullable = false,length = 34)
    private String lastName;
    @Basic
    @Column(name="summary", nullable = false, length = 200)
    private String summary;
@OneToMany(mappedBy = "instructor", fetch=FetchType.LAZY)
private Set<Course> courses =new HashSet<>();
@OneToOne(cascade = CascadeType.REMOVE)
@JoinColumn(name="user_id", referencedColumnName = "user_id", nullable = false)
private User user;


   public Instructor(String firstName, String lastName, String summary, User user) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.summary = summary;
    this.user = user;
}
public Instructor() {
}
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
        Instructor other = (Instructor) obj;
        if (instructorId == null) {
            if (other.instructorId != null)
                return false;
        } else if (!instructorId.equals(other.instructorId))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (summary == null) {
            if (other.summary != null)
                return false;
        } else if (!summary.equals(other.summary))
            return false;
        return true;
    }
    public Long getInstructorId() {
        return instructorId;
    }
    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
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
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Instructor [instructorId=" + instructorId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", summary=" + summary + "]";
    }
    
}
