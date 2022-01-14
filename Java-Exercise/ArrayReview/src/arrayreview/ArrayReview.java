/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayreview;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class ArrayReview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //input
        int[] arrayInt = createArrayNumber();
        printArray(arrayInt);
        System.out.println("Max of array : " +maxOfArray(arrayInt));
        System.out.println("Min of array : " +minOfArray(arrayInt));
        reverseArray(arrayInt);
    }
     public static void printArray(int[] arrayInput){
        System.out.println("we have an Array");
        for(int i = 0;i<arrayInput.length;i++){
            System.out.println(arrayInput[i]);
        }
    }
    public static int[] createArrayNumber(){
        int[] arrayInt = new int[8];
        arrayInt[0] = 10;
        arrayInt[1] = 2;
        arrayInt[2] = 5;
        arrayInt[3] = 20;
        arrayInt[4] = 15;
        arrayInt[5] = 7;
        arrayInt[6] = 3;
        arrayInt[7] = 8;
        return arrayInt;
    }
    
    public static int maxOfArray(int[] arrayInput){
        int max = arrayInput[0];
        for(int i = 1;i<arrayInput.length;i++){
            if(max<arrayInput[i]){
                max = arrayInput[i];
            }
        }
        return max;
    }
    public static int minOfArray(int[] arrayInput){
        int min = arrayInput[0];
        for(int i = 1;i<arrayInput.length;i++){
            if(min>arrayInput[i]){
                min = arrayInput[i];
            }
        }
        return min;
    }
    public static void reverseArray(int[] arrayInput){
        int[] reversedArray = new int[8];;
        for(int i = arrayInput.length-1;i>=0;i--){
            reversedArray[i] = arrayInput[arrayInput.length-1-i];
        }
        System.out.println("we have a reversed Array");
        for(int i = 0;i<reversedArray.length;i++){
            System.out.println(reversedArray[i]);
        }
    }
}
