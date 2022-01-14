/**
 * Created by My PC on 18/11/2017.
 */
public class Main {
	public static void main(String[] args) throws Exception {
		ProcessStudent ps = new ProcessStudent();   // tao doi tuong cua lop ProcessStudent
		Student[] student1 = null, student2 = null; // tao 2 doi tuong student
		student1 = ps.creat();  // nhap student
		ps.write(student1);     // viet vao file
		student2 = ps.read();   // doc tu file
		try {
			ps.show(student2);      //hien thi kq
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
