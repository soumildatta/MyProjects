import java.util.Scanner;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
	}
	
	//Converts user input to lowercase and removes spaces
	public static char[] wordProcessing (String input) {
		String formatted;
		formatted = input.replaceAll(" ", "").toLowerCase();
		return formatted.toCharArray();
	}
	
	public static char[] encrypt() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("You have chosen to encrypt.");
		System.out.print("Enter a sentence to be encrypted: ");
		String sentence_raw = scan.nextLine();
		//format user input for encrpytion
		char[] formatted_input;
		formatted_input = wordProcessing(sentence_raw);
		
		
		//placeholder
		char[] character = new char[10];
		return character;
	}
	
	public static char[] decrypt () {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("You have chosen to decrypt.");
		System.out.print("Enter a sentence to be decrypted: ");
		String sentence_raw = scan.nextLine();
		//format user input for decryption
		char[] formatted_input;
		formatted_input = wordProcessing(sentence_raw);
		
		
		//placeholder
		char[] character = new char[10];
		return character;
	}
}
