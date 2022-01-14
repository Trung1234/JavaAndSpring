import java.util.Scanner;

/**
 * Created by My PC on 18/05/2017.
 */
public class Main {
    public static String Rervere(String string){
        String reversed = "";
        for(int i = string.length() - 1; i >= 0; i--) {
            reversed += string.charAt(i);
        }
        return reversed;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("moi nhap vao chuoi \n");
        String s = scanner.nextLine();
        String result = Rervere(s);
        System.out.printf("Reversed String is " +result);
    }
}
