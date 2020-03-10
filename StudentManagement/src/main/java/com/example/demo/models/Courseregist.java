// Generated with g9.

package com.example.demo.models;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="courseregist")
public class Courseregist implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, precision=3)
    @GeneratedValue
    private int id;
    @ManyToOne(optional=false)
    @JoinColumn(name="courseid", nullable=false)
    private Course course;
    @ManyToOne(optional=false)
    @JoinColumn(name="studentid", nullable=false)
    private Student student;

    /** Default constructor. */
    public Courseregist() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for course.
     *
     * @return the current value of course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Setter method for course.
     *
     * @param aCourse the new value for course
     */
    public void setCourse(Course aCourse) {
        course = aCourse;
    }

    /**
     * Access method for student.
     *
     * @return the current value of student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Setter method for student.
     *
     * @param aStudent the new value for student
     */
    public void setStudent(Student aStudent) {
        student = aStudent;
    }

    /**
     * Compares the key for this instance with another Courseregist.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Courseregist and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Courseregist)) {
            return false;
        }
        Courseregist that = (Courseregist) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Courseregist.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Courseregist)) return false;
        return this.equalKeys(other) && ((Courseregist)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Courseregist |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
