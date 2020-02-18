// Generated with g9.

package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity(name="student")
public class Student implements Serializable {

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }
    
    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Column(name="Id", nullable=false, precision=4)
    private int id;
    @Column(name="Name", nullable=false, length=250)
    private String name;
    @Column(name="Mark", nullable=false, precision=2)
    private int mark;
    @Column(name="Class", nullable=false, length=5)
    private String class_;

    /** Default constructor. */
    public Student() {
        super();
    }

    public Student(int id, String name, int mark, String class_) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.class_ = class_;
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
     * Access method for class_.
     *
     * @return the current value of class_
     */
    public String getClass_() {
        return class_;
    }

    /**
     * Setter method for class_.
     *
     * @param aClass_ the new value for class_
     */
    public void setClass_(String aClass_) {
        class_ = aClass_;
    }

}
