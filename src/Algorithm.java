
public class Algorithm {
	
	private int numberOfCacheHits;
	private char[][] dataMatrix;
	
	//Getters
	public int getNumberOfCacheHits() {
		return this.numberOfCacheHits;
	}
	public char[][] getDataMatrix(){
		return this.dataMatrix;
	}
	
	//Setters
	public void setNumberOfCacheHits(int value) {
		this.numberOfCacheHits = value;
	}
	public void setDataMatrix(char[][] value) {
		this.dataMatrix = value;
	}
}
