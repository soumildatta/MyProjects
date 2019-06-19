import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*
		System.out.println("Enter a sentence to be encrypted");
		String testing = scan.nextLine();
		String format;
		format = testing.replaceAll(" ", "").toLowerCase();
		
		char[] array = format.toCharArray();
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		*/
		
	}
	
	public char[] wordProcessing (String input) {
		//format string for processing
		String formatted;
		formatted = input.replaceAll(" ", "").toLowerCase();
		return formatted.toCharArray();
	}
	
	public static char[] encrypt() {
		Scanner scan = new Scanner(System.in);
		
		print("You have chosen to encrypt.");
		System.out.print("Enter a sentence to be encrypted: ");
		String sentenceRaw = scan.nextLine();
		
		//placeholder
		char[] character = new char[10];
		return character;
	}
	
	public static char[] decrypt () {
		Scanner scan = new Scanner(System.in);
		
		print("You have chosen to decrypt.");
		System.out.print("Enter a sentence to be decrypted: ");
		String sentenceRaw = scan.nextLine();
		
		//placeholder
		char[] character = new char[10];
		return character;
	}
	
	public static void print(String input) {
		System.out.println(input);
	}
}
