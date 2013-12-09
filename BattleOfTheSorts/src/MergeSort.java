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
public class MergeSort {
	
	/**
     * Sorts a given list using merge sort.
     * 
     * @param list
     */
    public static <E extends Comparable<E>> void mergeSort(E[] arr) 
    {
    	helpMerge(arr,0,arr.length);
    }
    
    /**
     * Helper method for mergeSort that takes part of the arr given the start and end points.
     * Recursively called within itself.
     * 
     * @param temparr
     * @param start
     * @param end
     */
    private static <E extends Comparable<E>> void helpMerge(E[] tempArr,int start, int end)
    {
    	if(start==end-1)
    	{return;}
    	
    	int length = end;
    	int mid = (start+end)/2;
    	//sorts and merges the beginning half
    	helpMerge(tempArr,start,mid);
    	//sorts and merges the ending half
    	helpMerge(tempArr,mid,end);
    	//optimizes merge by checking if both halves are already in correct order
    	if(tempArr[mid-1].compareTo(tempArr[mid])<0)
    	{return;}
    	
    	int i=start;int j=mid; int k=start;
    	E[] working = tempArr.clone();
    	//runs through elements of the list and copys the next smallest item to the list
    	while( (i<mid)&&(j<length) )
    	{
    		if(working[i].compareTo(working[j])<=0)
    		{tempArr[k] = working[i];k=k+1;i=i+1;}
    		else
    		{tempArr[k] = working[j];k=k+1;j=j+1;}
    	}
    	//copys remaining elements (if any) from the array that has any leftover
    	while(i<mid)
    	{tempArr[k] = working[i];k=k+1;i=i+1;}
    	while(j<length)
    	{tempArr[k] = working[j];k=k+1;j=j+1;}    	
    }
    
}
