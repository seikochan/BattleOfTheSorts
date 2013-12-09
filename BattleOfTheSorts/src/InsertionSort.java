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
public class InsertionSort {
	
	/**
	 *  Sorts a given list using the insertion sort.
	 *  
	 * @param list
	 */
    public static <E extends Comparable<E>> void insertionSort(E[] dataArr)
    {
    	//go through all elements
    	for(int i=0;i<dataArr.length-1;i++)
    	{
    		//if next element is less than current element loop through all sorted elements and keep moving the element left until it is its proper place
    		if(dataArr[i+1].compareTo(dataArr[i])<0)
    		{
    			E temp = dataArr[i];
    			dataArr[i] = dataArr[i+1];
    			dataArr[i+1] = temp;
    			for(int j=i-1;j>=0;j--)
    			{
    				if(dataArr[j+1].compareTo(dataArr[j])<0)
    				{
    					E temp2 = dataArr[j];
    	    			dataArr[j] = dataArr[j+1];
    	    			dataArr[j+1] = temp2;
    				}
    				else
    				{break;}
    			}
    		}
    	}

    }
}
