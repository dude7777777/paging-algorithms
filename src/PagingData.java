import java.util.ArrayList;

public class PagingData {
	
	private String referenceString;
	private int referenceStringUniqueness;
	private  int numberOfSlots;
	
	private ArrayList<Algorithm> algorithms = new ArrayList<Algorithm>();
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
		char[] reference = new char[length];
		int randomNumber, i;
		
		for (i=0; i<length; i++) {
			randomNumber = Index.RND.nextInt(this.referenceStringUniqueness);
			char x = alphabet[randomNumber];
			reference[i] = x;
		}
		
		String referenceString = new String(reference);
		this.referenceString = referenceString;
	}
	
	public void runAlgorithm(String value) {
		switch(value) {
			case "FIFO": {
				Fifo fifo = new Fifo(this);
				this.algorithms.add(fifo);
				break;
			}
			case "LRU": {
				Lru lru = new Lru(this);
				this.algorithms.add(lru);
				break;
			}
			case "MIN": {
				Min min = new Min(this);
				this.algorithms.add(min);
				break;
			}
			case "RAND": {
				Rand rand = new Rand(this);
				this.algorithms.add(rand);
				break;
			}
		}
		
	}
	
	public void printOutput() {
		for(Algorithm a : this.algorithms) {
			a.print();
		}
		
		//("CacheRates");
		//("Best");
		//("Worst");
		
	}
}
