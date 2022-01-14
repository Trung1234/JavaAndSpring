/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cutstring;

/**
 *
 * @author My PC
 */
public class CutString {
 static String check(String input){
		String output = "";
		String inFor = "";
		for(int i = 1; i < input.length(); i++){
			
			if(input.charAt(i) == input.charAt(i-1)){
				
				if(inFor == "" ){
					inFor = inFor + input.charAt(i-1);
				}					
				inFor = inFor + input.charAt(i);
			}else{
				if(inFor.length() > output.length())
					output =inFor;
				inFor = "";
			}
		}
		return output;
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic hereSystem.out.println("hello");
		System.out.print(check("abkkkkkbbbmmmmmmmijk"));
    }
    
}
