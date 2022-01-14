import java.io.Serializable;

/**
 * Created by My PC on 18/11/2017.
 */
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;    // ID of Serializable
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// cac ham get, set gia tri cac bien
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
