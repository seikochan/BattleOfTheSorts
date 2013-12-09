
public class QuickSort {

    
    
    /**
     * Sorts a given list using quick sort.
     * Optimization(s):    checks first to see if the two partitions are already sorted and, if so, combines them and moves on.
     * 
     * @param list
     */
    public static <E extends Comparable<E>> void quickSort(E[] strArr) 
    {
    	partition(strArr,0,strArr.length-1);
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
