
public class HeapSort {
	public static <E extends Comparable<E>> void heapSort(E[] dataArr){
		//puts data into max-heap order
		heapify(dataArr);
		
		int end = dataArr.length - 1;
		while(end > 0){
			//swap the root(which is the max value) of heap with last element of heap
			E temp = dataArr[end];
			dataArr[end] = dataArr[0];
			dataArr[0] = temp;
			
			//decrease the size of heap by 1 so that previous max value will stay in proper place
			end--;
			//put remaining data back into max-heap order
			shiftDown(dataArr, 0 , end);
		}
	}
	
	public static <E extends Comparable<E>> void heapify(E[] dataArr){
		int length = dataArr.length;
		//start is assigned the index in the array of the last parent node
		int start = (length-2)/2;
		
		while(start >= 0){
			//move the node at start to its proper place so that all nodes below start index are in heap order
			shiftDown(dataArr, start, length -1);
			start--;	
		}
	}

	public static <E extends Comparable<E>> void shiftDown(E[] dataArr, int start, int end){
		int nodeIndex = start;
		
		//while it has at least 1 child
		while( (nodeIndex *2 + 1) <= end){
			int leftChild = nodeIndex * 2 + 1;
			int rightChild = nodeIndex * 2 + 2;
			//tracks which child to swap with
			int swap = nodeIndex;
			
			if(dataArr[swap].compareTo(dataArr[leftChild]) < 0){
				swap = leftChild;
			}
			if( (rightChild <= end)  && (dataArr[swap].compareTo(dataArr[rightChild]) < 0) ){
				swap = rightChild;
			}
			//check if we actually need to swap
			if(swap != nodeIndex){
				E temp = dataArr[nodeIndex];
				dataArr[nodeIndex] = dataArr[swap];
				dataArr[swap] = temp;
			}else{
				return;
			}
		}
	}
}