import java.io.*;
import java.util.Scanner;

/**
 * Created by My PC on 18/11/2017.
 */
public class ProcessStudent {
	public Student[] creat() {      // Input the data from Keyboard
		int n;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter number of student: ");
		n = Integer.parseInt(scan.nextLine());  //nhap so sinh vien
		
		Student[] student = new Student[n];
		
		for (int i = 0; i < n; i++) {
			System.out.print("Enter name: ");   // nhap ten sv thu i
			String name = scan.nextLine();
			System.out.print("Enter age: ");    // nhap tuoi
			int age = Integer.parseInt(scan.nextLine());    // tranh troi lenh nhu khi dung scan.nextInt()
			student[i] = new Student(name, age);    // khoi tao doi tuong Student thu i
		}
		
		scan.close();
		return student;
	}
	
	public void write(Student[] student) {  //ghi theo Object
		try {   // dat try cacth de tranh ngoai le khi tao va ghi File
			FileOutputStream f = new FileOutputStream("student.dat");   // tao file f tro den student.dat
			ObjectOutputStream oStream = new ObjectOutputStream(f); // dung de ghi theo Object vao file f
			oStream.writeObject(student);   // ghi student theo kieu Object vao file
			oStream.close();
		} catch (IOException e) {
			System.out.println("Error Write file");
		}
	}
	
	public Student[] read() {       // doc theo Object
		Student[] student = null;
		try {   // dat try cacth de tranh ngoai le khi tao va doc File
			FileInputStream f = new FileInputStream("student.dat"); // tao file f tro den student.dat
			ObjectInputStream inStream = new ObjectInputStream(f);  // dung de doc theo Object vao file f
			// dung inStream doc theo Object, ep kieu tra ve la Student
			student = (Student[]) inStream.readObject();
			inStream.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		} catch (IOException e) {
			System.out.println("Error Read file");
		}
		return student;
	}
	
	public void show(Student[] student) throws Exception {      //In data doc duoc tu file ra man hinh
		try {
			for (int i = 0; i < student.length; i++) {
				System.out.println((i + 1) + " : My name is "
						+ student[i].getName() + ". I am "
						+ student[i].getAge() + " years old");
			}
		} catch (NullPointerException e) {
			System.out.println("File Empty");
		}
	}
}
