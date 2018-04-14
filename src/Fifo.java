
public class Fifo extends Algorithm {
	
	public Fifo(PagingData data) {
		int currentSlot = 0;
		char[] slots = new char[data.getNumberOfSlots()];
		int i,j = 0;
		String referenceString = data.getReferenceString();
		
		//initialize dataMatrix with zeros
		char[][] dataMatrix = new char[data.getNumberOfSlots()][referenceString.length()];
		for(i=0; i<data.getNumberOfSlots(); i++) {
			for(j=0; j<referenceString.length(); j++) {
				dataMatrix[i][j] = '0';
			}
		}
		//initialize slots wiht zeros
		for(i=0; i<slots.length; i++) {
			slots[i]='0';
		}
		
		//FIFO
		for(i=0; i<data.getReferenceString().length(); i++) {
			for(j=0; j<currentSlot; j++) {
				if(slots[j]==referenceString.toCharArray()[i]) {
					//cache hit
					break;
				}
			}
			//cache miss
			dataMatrix[currentSlot][i] = referenceString.toCharArray()[i];
			currentSlot++;
			
			//reset currentSlot if max is reached
			if(currentSlot>data.getNumberOfSlots()) {
				currentSlot = 0;
			}
		}
	}

}
