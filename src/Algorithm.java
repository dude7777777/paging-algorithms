import java.text.DecimalFormat;

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
		char[] matrixLine = this.dataMatrix[0];
		double rate = (double)this.numberOfCacheHits/matrixLine.length;
		DecimalFormat df = new DecimalFormat("#0.00");
		
		System.out.print(this.name);
		System.out.print(":  ");
		System.out.print(this.numberOfCacheHits);
		System.out.print(" of ");
		System.out.print(matrixLine.length);
		System.out.print(" = ");
		System.out.println(df.format(rate));
	}
}
