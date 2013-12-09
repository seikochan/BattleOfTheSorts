
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
