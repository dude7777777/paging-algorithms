import java.util.Random;
import java.util.Scanner;

public class Index {
	
	public static Random RND = new Random();

	public static void main(String[] args) {
		//Get user input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("How big is the reference string? ");
		int length = keyboard.nextInt(); 
		System.out.print("How unique is the string? ");
		int unique = keyboard.nextInt();
		System.out.print("How many slots are there? ");
		int numberOfSlots = keyboard.nextInt();
		
		//Set paging data object
		PagingData pagingData = new PagingData();
		pagingData.setReferenceStringUniqueness(unique);
		pagingData.setNumberOfSlots(numberOfSlots);
		pagingData.generateRefenceString(length);
		
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
