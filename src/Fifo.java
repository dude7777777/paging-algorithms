
public class Fifo extends Algorithm {
	
	public Fifo(PagingData data) {
		char[] slots = new char[data.getNumberOfSlots()];
		int currentSlot = 0;
		int i,j = 0;
		String referenceString = data.getReferenceString();
		
		//initialize dataMatrix with spaces
		char[][] dataMatrix = new char[data.getNumberOfSlots()][referenceString.length()];
		for(i=0; i<data.getNumberOfSlots(); i++) {
			for(j=0; j<referenceString.length(); j++) {
				dataMatrix[i][j] = ' ';
			}
		}
		//initialize slots with spaces
		for(i=0; i<slots.length; i++) {
			slots[i]=' ';
		}
		
		//FIFO
		boolean skip = false;
		for(i=0; i<referenceString.length(); i++) {
			skip = false;
			for(j=0; j<currentSlot; j++) {
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
//		System.out.println(referenceString);
//		String x;
//		for(i=0; i<dataMatrix.length; i++) {
//			x = new String(dataMatrix[i]);			
//			System.out.println(x);
//		}
	}
	
	public void print() {
		System.out.println("sub");
	}

}
