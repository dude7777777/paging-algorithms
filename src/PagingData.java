import java.util.ArrayList;

public class PagingData {
	
	private String referenceString;
	private int referenceStringUniqueness;
	private  int numberOfSlots;
	
	private Fifo fifo;
	private Lru lru;
	private Min min;
	private Rand rand;
	
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
		switch(value) {
			case "FIFO": {
				Fifo fifo = new Fifo(this);
				this.fifo = fifo;
				break;
			}
			case "LRU": {
				Lru lru = new Lru(this);
				this.lru = lru;
				break;
			}
			case "MIN": {
				Min min = new Min(this);
				this.min = min;
				break;
			}
			case "RAND": {
				Rand rand = new Rand(this);
				this.rand = rand;
				break;
			}
		}
		
	}
	
	public void printOutput(String string) {
		// TODO Auto-generated method stub
		
	}
}
