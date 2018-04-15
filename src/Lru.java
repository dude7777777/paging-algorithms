
public class Lru extends Algorithm {

	public Lru(PagingData data) {
		super.setName("LRU  ");
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
		//initialize slotUsage with zeros
		int[] slotUsage = new int[data.getNumberOfSlots()];
		for(i=0; i<slotUsage.length; i++) {
			slotUsage[i] = 0;
		}
		
		//LRU
		boolean skip = false;
		int slotToChange = 0;
		int min = 2147483647;
		for(i=0; i<referenceString.length(); i++) {
			skip = false;
			min = 2147483647;
			for(j=0; j<slots.length; j++) {
				if(slots[j]==referenceString.toCharArray()[i]) {
					//cache hit
					this.setNumberOfCacheHits(this.getNumberOfCacheHits()+1);
					dataMatrix[j][i] = '+';
					slotUsage[j]++;
					skip = true;
					break;
				}
			}
			if(!skip) {
				//cache miss
				for(j=0; j<slotUsage.length; j++) {
					if(slotUsage[j]<min) {
						min = slotUsage[j];
						slotToChange = j;
					}
				}
				//if empty replace it first
				for(j=0; j<slots.length; j++) {
					if(slots[j]==' ') {
						slotToChange = j;
						break;
					}
				}
				dataMatrix[slotToChange][i] = referenceString.toCharArray()[i];
				slots[slotToChange] = referenceString.toCharArray()[i];
				slotUsage[slotToChange] = 0;
			}
		}
		this.setDataMatrix(dataMatrix);
	}
	
	public void printMatrix(PagingData data) {
		for(int times=0; times<=data.getReferenceString().length(); times++) {
			System.out.print("--");
		}
		System.out.println();
		char[] matrixLine;
		int i, j;
		for(i=0; i<data.getNumberOfSlots(); i++) {
			System.out.print("LRU   " + (i+1) + ": ");
			matrixLine = super.getDataMatrix()[i];
			for(j=0; j<matrixLine.length; j++) {
				System.out.print(matrixLine[j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}