import java.util.Random;
import java.util.Scanner;

public class Index {
	
	public static Random RND = new Random();

	public static void main(String[] args) {
		//Get user input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter page reference pattern length: ");
		int length = keyboard.nextInt(); 
		System.out.print("Enter number of unique pages: ");
		int unique = keyboard.nextInt();
		System.out.print("Enter number of slots: ");
		int numberOfSlots = keyboard.nextInt();
		System.out.println();
		
		//Set paging data object
		PagingData pagingData = new PagingData();
		pagingData.setReferenceStringUniqueness(unique);
		pagingData.setNumberOfSlots(numberOfSlots);
		pagingData.generateRefenceString(length);
		
		System.out.print("Ref Str: ");
		char[] charReference = pagingData.getReferenceString().toCharArray();
		for(int i=0; i<charReference.length; i++) {
			System.out.print(charReference[i] + " ");
		}
		System.out.println();
		
		//Process
		pagingData.runAlgorithm("FIFO");
		pagingData.runAlgorithm("LRU");
		pagingData.runAlgorithm("MIN");
		pagingData.runAlgorithm("RAND");
		
		//Output
		pagingData.printOutput();
		
		//Cleanup
		keyboard.close();
	}
}
