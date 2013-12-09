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
public class QuickSort {

    
    
    /**
     * Sorts a given list using quick sort.
     * Optimization(s):    checks first to see if the two partitions are already sorted and, if so, combines them and moves on.
     * 
     * @param list
     */
    public static <E extends Comparable<E>> void quickSort(E[] dataArr) 
    {
    	partition(dataArr,0,dataArr.length-1);
    }
    
    /**
     * Helper method for otherSort (quick sort).
     * Partitions the list into smaller parts and is recursively called within itself.
     * 
     * @param tempList
     * @param start
     * @param end
     */
    private static <E extends Comparable<E>> void partition(E[] tempArr, int start,int end)
    {
    	if(end-start<1)
    	{return;}
    	
    	int pivot =(start + (int)(Math.random() * (end - start)));
    	E pivotValue = tempArr[pivot];
    	int front = start;
    	int back = end;
    	boolean changed;
    	
    	do
    	{
    		changed = false;
	        while(front<pivot)
	        {
	    		if(tempArr[front].compareTo(pivotValue)>0)
	    		{
	    			while(back>=pivot)
	    			{
	    				if(tempArr[back].compareTo(pivotValue)<=0)
	    				{
	    					E temp = tempArr[back];
	    					tempArr[back] = tempArr[front];
	    					tempArr[front] = temp;
	    					if(tempArr[back].equals(pivotValue)){pivot=back;pivotValue=tempArr[pivot];}
	    					if(tempArr[front].equals(pivotValue)){pivot=front;pivotValue=tempArr[pivot];}
	    					back--;
	    					break;
	    				}
	    				back--;
	    			}
	    		}
	    		front++;
	    	}
	        while(back>pivot)
	        {
				if(tempArr[back].compareTo(pivotValue)<0)
				{
					E temp = tempArr[back];
					tempArr[back] = pivotValue;
					tempArr[pivot] = temp;
					pivot=back;
					changed=true;
					break;
				}
				back--;
	        }
    	}
    	while(changed);
        
        partition(tempArr,start,pivot);
        partition(tempArr,pivot+1,end);
    }
}
