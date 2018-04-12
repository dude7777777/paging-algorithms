
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
}
