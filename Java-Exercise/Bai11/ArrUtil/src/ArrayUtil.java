
import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by My PC on 05/11/2017.
 */
public class ArrayUtil {
	int n;
	int array[];
	
	public ArrayUtil(int n) {
		this.n = n;
		array= new int[n];
		Random rd = new Random();
		System.out.println("random 1 number bettween 50");
		for (int i = 0; i < n; i++) {
			array[i]= rd.nextInt(n+1);
			System.out.println("Item " + (i + 1) + ":" + array[i]);
		}
	}
	public  void findTraingle(){
		System.out.println("Các bộ cạnh tam giác là: ");
		for(int i=0;i<n-2;i++){
			//Giả sử: array[i] là cạnh a, array[i+1] là cạnh b, array[i+2] là cạnh c
			
			int a = array[i];
			
			int b = array[i+1];
			
			int c = array[i+2];
			if(a+b>c && a+c>b && b+c>a){
				//In ra bộ 3 cạnh a,b,c thỏa mãn là 3 cạnh tam giác
				System.out.println(a+"," +b+","+c);
			}
		}
	}

}
