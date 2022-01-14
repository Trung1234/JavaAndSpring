/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americanflag;

/**
 *
 * @author LENOVO
 */
public class AmericanFlag {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createFlag();
    }
    public static void createFlag(){
        for(int i=1;i<=3;i++){
            System.out.println("* * * * * * ==================================\n" +
            " * * * * *  ==================================\n" +
            "* * * * * * ==================================");
        }
        for(int i=1;i<=6;i++){
            System.out.println("==============================================");
        }
    }
}
