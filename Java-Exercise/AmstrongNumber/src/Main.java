import java.util.Scanner;

/**
 * Created by My PC on 14/08/2017.
 */
public class Main {
    public static boolean Amstrong(int n){
        int temp = n;
        int sum = 0;
        while(temp > 0){
            sum = sum + (temp%10)*(temp%10)*(temp%10);
            temp = temp/10;
        }
        if(sum == n) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("moi nhap vao so n:  ");
        int n = sc.nextInt();
        if(Amstrong(n)==true) System.out.println("La so amstrong");
        else System.out.println("khong la so amstrong");
    }
}
