
public class Algorithm {
	
	private int numberOfCacheHits=0;
	private char[][] dataMatrix;
	private String name;
	
	//Getters
	public int getNumberOfCacheHits() {
		return this.numberOfCacheHits;
	}
	public char[][] getDataMatrix(){
		return this.dataMatrix;
	}
	public String getName() {
		return this.name;
	}
	
	//Setters
	public void setNumberOfCacheHits(int value) {
		this.numberOfCacheHits = value;
	}
	public void setDataMatrix(char[][] value) {
		this.dataMatrix = value;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	//Methods
	public void printMatrix(PagingData data) {
		
	}
	public void printCacheHits() {
		System.out.print(this.name);
		System.out.print(":  ");
		System.out.print(this.numberOfCacheHits);
		System.out.print(" of ");
		char[] matrixLine = this.dataMatrix[0];
		System.out.print(matrixLine.length);
		System.out.print(" = ");
		double rate = this.numberOfCacheHits/matrixLine.length;
		System.out.println(rate);
	}
}
