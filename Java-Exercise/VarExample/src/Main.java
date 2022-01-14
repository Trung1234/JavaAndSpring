public class Main {
    public static void main(String[] args) {
        Main demo2 = new Main();
        // tạo đối tượng sinh viên
        SinhVien sinhVien = new SinhVien("Lan Anh");
        // lấy tên trước khi gọi phương thức
        System.out.println("Trước khi gọi method change1: "+sinhVien.getName());
        demo2.change1(sinhVien);
        System.out.println("Sau khi gọi method change1 : "+sinhVien.getName());

        System.out.println("Trước khi gọi method change2: "+sinhVien.getName());
        demo2.change2(sinhVien);
        System.out.println("Sau khi gọi method change2: "+sinhVien.getName());
    }

    public void change1(SinhVien sinhVien){
        SinhVien objSV = new SinhVien();
        sinhVien = objSV;
    }

    public void change2(SinhVien sinhVien){
        sinhVien.setName("Phú Trần IT");
    }
}
