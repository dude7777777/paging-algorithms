
public class Fifo extends Algorithm {
	
	public Fifo(PagingData data) {
		super.setName("FIFO ");
		int currentSlot = 0;
		int i, j = 0;
		String referenceString = data.getReferenceString();
		
		//initialize dataMatrix with spaces
		char[][] dataMatrix = new char[data.getNumberOfSlots()][referenceString.length()];
		for(i=0; i<data.getNumberOfSlots(); i++) {
			for(j=0; j<referenceString.length(); j++) {
				dataMatrix[i][j] = ' ';
			}
		}
		//initialize slots with spaces
		char[] slots = new char[data.getNumberOfSlots()];
		for(i=0; i<slots.length; i++) {
			slots[i] = ' ';
		}
		
		//FIFO
		boolean skip = false;
		for(i=0; i<referenceString.length(); i++) {
			skip = false;
			for(j=0; j<slots.length; j++) {
				if(slots[j]==referenceString.toCharArray()[i]) {
					//cache hit
					this.setNumberOfCacheHits(this.getNumberOfCacheHits()+1);
					dataMatrix[j][i] = '+';
					skip = true;
					break;
				}
			}
			if(!skip) {
				//cache miss
				dataMatrix[currentSlot][i] = referenceString.toCharArray()[i];
				slots[currentSlot] = referenceString.toCharArray()[i];
				currentSlot++;
				
				//reset currentSlot if max is reached
				if(currentSlot>=data.getNumberOfSlots()) {
					currentSlot = 0;
				}
			}
		}
		this.setDataMatrix(dataMatrix);
	}
	
	public void printMatrix(PagingData data) {
		char[] matrixLine;
		int i, j;
		for(i=0; i<data.getNumberOfSlots(); i++) {
			System.out.print("FIFO  " + (i+1) + ": ");
			matrixLine = super.getDataMatrix()[i];
			for(j=0; j<matrixLine.length; j++) {
				System.out.print(matrixLine[j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
