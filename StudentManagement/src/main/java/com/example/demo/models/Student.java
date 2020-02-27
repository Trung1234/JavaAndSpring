// Generated with g9.

package com.example.demo.models;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="student")
public class Student implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, precision=3)
    private int id;
    @Column(nullable=false, length=255)
    private String name;
    @Column(precision=3)
    private int mark;
    @OneToMany(mappedBy="student")
    private Set<Courseregist> courseregist;

    /** Default constructor. */
    public Student() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
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
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for mark.
     *
     * @return the current value of mark
     */
    public int getMark() {
        return mark;
    }

    /**
     * Setter method for mark.
     *
     * @param aMark the new value for mark
     */
    public void setMark(int aMark) {
        mark = aMark;
    }

    /**
     * Access method for courseregist.
     *
     * @return the current value of courseregist
     */
    public Set<Courseregist> getCourseregist() {
        return courseregist;
    }

    /**
     * Setter method for courseregist.
     *
     * @param aCourseregist the new value for courseregist
     */
    public void setCourseregist(Set<Courseregist> aCourseregist) {
        courseregist = aCourseregist;
    }

    /**
     * Compares the key for this instance with another Student.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Student and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Student)) {
            return false;
        }
        Student that = (Student) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Student.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Student)) return false;
        return this.equalKeys(other) && ((Student)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Student |");
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
