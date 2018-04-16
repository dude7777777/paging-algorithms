
public class Min extends Algorithm {

	public Min(PagingData data) {
		super.setName("MIN  ");
		int i, j, k = 0;
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
		//initialize distances with zeros
		int[] distances = new int[data.getNumberOfSlots()];
		for(i=0; i<slots.length; i++) {
			distances[i] = 0;
		}
		
		//MIN
		boolean skip = false;
		int slotToChange = 0;
		int max = 0;
		for(i=0; i<referenceString.length(); i++) {
			skip = false;
			max = 0;
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
				
				//reset distances
				for(j=0; j<slots.length; j++) {
					distances[j] = 0;
				}
				//calculate distances
				for(j=0; j<slots.length; j++) {
					for(k=i; k<referenceString.length(); k++) {
						distances[j] = k;
						if(slots[j]==referenceString.toCharArray()[k]) {
							break;
						}
						if(k==referenceString.length()-1) {
							distances[j] = k+1;
						}
					}
				}
				
				//get farthest distance
				for(j=0; j<distances.length; j++) {
					if(distances[j]>max) {
						max = distances[j];
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
			}
		}
		this.setDataMatrix(dataMatrix);
	}
	
	public void printMatrix(PagingData data) {
		for(int times=0; times<=data.getReferenceString().length(); times++) {
			System.out.print("--");
		}
		System.out.println("-------");
		char[] matrixLine;
		int i, j;
		for(i=0; i<data.getNumberOfSlots(); i++) {
			System.out.print("MIN   " + (i+1) + ": ");
			matrixLine = super.getDataMatrix()[i];
			for(j=0; j<matrixLine.length; j++) {
				System.out.print(matrixLine[j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
