import java.util.ArrayList;

public class PagingData {
	
	private String referenceString;
	private int referenceStringUniqueness;
	private  int numberOfSlots;
	
	//Getters
	public String getReferenceString() {
		return this.referenceString;
	}
	public int getReferenceStringUniqueness() {
		return this.referenceStringUniqueness;
	}
	public int getNumberOfSlots() {
		return this.numberOfSlots;
	}
	
	//Setters
	public void setReferenceString(String value) {
		this.referenceString = value;
	}
	public void setReferenceStringUniqueness(int value) {
		this.referenceStringUniqueness = value;
	}
	public void setNumberOfSlots(int value) {
		this.numberOfSlots = value;
	}
	
	//Methods	
	public void generateRefenceString(int length) {
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		ArrayList<Character> reference = new ArrayList<Character>();
		int randomNumber, i;
		
		for (i=0; i<length; i++) {
			randomNumber = Index.RND.nextInt(this.referenceStringUniqueness);
			char x = alphabet[randomNumber];
			reference.add(x);
		}
		this.referenceString = reference.toString();
	}
	
	public void runAlgorithm(String value) {
		// TODO Auto-generated method stub
		
	}
	
	public void printOutput(String string) {
		// TODO Auto-generated method stub
		
	}
}
