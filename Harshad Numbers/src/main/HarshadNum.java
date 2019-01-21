/*Harshad Number (or Niven number) is an 
 * integer that is divisible by the sum of its
 * digits
 */

package main;
import java.util.*;
import java.io.*;

public class HarshadNum {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		//option section
		System.out.println("Welcome to the Harshad Number Calculator");
		int loop = 0;
		
		while(loop == 0)
		{
			//loop here to let user decide what to do next
			System.out.println("\nChoose an option by entering the number related to the options listed below");
			System.out.println("1. Check to see if a number is a Harshad number");
			System.out.println("2. Get a specified number of Harshad numbers"); 
			System.out.println("3. Read from prewritten file"); 
			System.out.println("4. Learn more about Harshad Numbers");
			System.out.println("5. Exit");
	
			try {
				System.out.print("\nYour choice: ");
				int choice = scan.nextInt();
				switch(choice)
				{
					case 1:
						optionOne();
						break;
					case 2:
						optionTwo();
						break;
					case 3:
						optionThree();
						break;
					case 4:
						optionFour();
						break;
					case 5:
						System.out.println("Thank you for using the Harshad Number Calculator");
						break;
					default:
						System.out.println("Invalid option");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid option choice");
			}
			String loopStr;
			System.out.print("Do you want to run this application again? (y/n): ");
			scan.nextLine();
			loopStr = scan.nextLine();
			
			if(loopStr.equals("y") || loopStr.equals("yes"))
			{
				loop = 0;
			}
			else
			{
				loop = -1;
				System.out.println("\nThank you for using the Harshad Number Calculator!");
			}
		}
	}
	
	public static void optionOne()
	{
		Scanner scan = new Scanner(System.in);
		int original;
		
		System.out.print("\nEnter the number to be checked: ");
		original = scan.nextInt();
		
		if(checkNum(original) == 0)
			System.out.println("\nThis is a Harshad Number!");
		else
			System.out.println("\nThis is not a Harshad Number");
	}
	
	public static void optionTwo() throws IOException
	{
		Scanner scan = new Scanner(System.in);
		int amount;
		int digits;
		int counter = 0;
		
		System.out.print("\nEnter the number of Harshad Numbers you want: ");
		amount = scan.nextInt();
		/*
		 *digit support
		System.out.print("\nEnter the number of digits you want your Harshad Number to have: "); sleep(500);
		digits = scan.nextInt();
		*/
		
		int[] array = new int[amount];
		
		for(int i = 10; counter < amount ; i++)
		{
			int number = checkNum(i);
			
			if(number == 0) {
				System.out.println(i);
				array[counter] = i;
				counter++;
			}
			sleep(200);
		}
		
		System.out.println("Would you like to create a .txt file with these numbers? (y/n): ");
		scan.nextLine();
		String answer = scan.nextLine();
		if(answer.equals("y") || answer.equals("yes"))
		{
			System.out.print("Enter the name of the file: ");
			String name = scan.nextLine();
			writeToFile(name, array);
			System.out.println("\nThank you for using the Harshad Number Calculator!");
			System.out.println("You can find your text file in the program folder");
		}
		else
			System.out.println("Thank you for using the Harshad Number Calculator!");
	}
	
	public static void optionThree() throws IOException
	{
		Scanner scan = new Scanner(System.in);
		String name;
		
		System.out.print("\nEnter the file name: ");
		name = scan.nextLine();
		sleep(500);
		
		System.out.print("\nOutput: ");
		sleep(100);
		readFromFile(name);
	}
	
	public static void optionFour()
	{
		/*
		 * information 
		 * about 
		 * harshad
		 * numbers 
		 * here
		 */
		System.out.println(" \nA Harshad number is a positive integer which is "
				+ "\ndivisible by the sum of its digits, also called a Niven number "
				+ "\n(Kennedy et al. 1980) or a multidigital number (Kaprekar 1955). "
				+ "\nThe first few are 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 18, 20, 21, 24, ... "
				+ "\n(OEIS A005349). Grundman (1994) proved that there is no sequence "
				+ "\nof more than 20 consecutive Harshad numbers, and found the smallest "
				+ "\nsequence of 20 consecutive Harshad numbers, each member of which has "
				+ "\n44363342786 digits.");
		sleep(5000);
		System.out.println("\nGrundman (1994) defined an n-Harshad (or n-Niven) number to "
				+ "\nbe a positive integer which is divisible by the sum of its digits in "
				+ "\nbase n>=2. Cai (1996) showed that for n=2 or 3, there exists an infinite "
				+ "\nfamily of sequences of consecutive n-Harshad numbers of length 2n.");
		
	}
	
	public static void readFromFile(String name) throws IOException
	{
		File file = new File(name+".txt");
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNext())
		{
			sleep(90);
			String number = inputFile.nextLine();
			System.out.print(number + " ");
		}
		inputFile.close();
		System.out.println("Finished reading from file");
	}
	
	public static void writeToFile(String name, int[] array) throws IOException
	{
		FileWriter fw = new FileWriter(name+".txt");
		PrintWriter outputFile = new PrintWriter(fw);
		System.out.println("Writing to file...");
		
		for(int i = 0; i < array.length; i++) {
			outputFile.println(array[i]);
		}
		
		outputFile.close(); 
		sleep(1000);
		System.out.println("Successfully written to file");
	}
	
	public static int checkNum(int number)
	{
		String num = Integer.toString(number);
		char[] numbers = num.toCharArray();
		
		int sum = 0;
		for(int i = 0; i < numbers.length; i++)
		{
			sum += Character.getNumericValue(numbers[i]);
		}
		int originalNum = Integer.parseInt(num);
		int modValue = originalNum % sum;
		
		return modValue;
	}

	public static void sleep(int time)
	{
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException e) {}
	} 
}