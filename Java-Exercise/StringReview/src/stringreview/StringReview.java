/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringreview;

/**
 *
 * @author LENOVO
 */
public class StringReview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String parent = "python";
        String child = "thocn";
        if(isEndWithSubString(parent, child)){
            System.out.println("isEndWithSubString");
        }else{
            System.out.println("is not EndWithSubString");
        }
    }
    //check whether a given string ends with the contents of another string.
    public static boolean isEndWithSubString(String parent, String child){
        boolean isContain = false;
        for (int i = child.length()-1; i>0; i--) {
            for (int j = parent.length()-1; j>parent.length()-child.length(); j--) {
                if(parent.charAt(j)==child.charAt(i)){
                    isContain = true;
                }else{
                    isContain = false;
                }
        }
        }
        return isContain;
    }
}
