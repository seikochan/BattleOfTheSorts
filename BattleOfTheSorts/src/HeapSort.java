/*
 * Copyright (c) 2013, Jasmine Ishigami
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Jasmine Ishigami ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Jasmine Ishigami BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
			
			if(dataArr[swap]
					.compareTo(dataArr[leftChild]) < 0){
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