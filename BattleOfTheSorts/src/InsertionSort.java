
public class InsertionSort {
	/**
	 *  Sorts a given list using the insertion sort.
	 *  
	 * @param list
	 */
    public static <E extends Comparable<E>> void insertionSort(E[] strArr)
    {
    	for(int i=0;i<strArr.length-1;i++)
    	{
    		if(strArr[i+1].compareTo(strArr[i])<0)
    		{
    			E temp = strArr[i];
    			strArr[i] = strArr[i+1];
    			strArr[i+1] = temp;
    			for(int j=i-1;j>=0;j--)
    			{
    				if(strArr[j+1].compareTo(strArr[j])<0)
    				{
    					E temp2 = strArr[j];
    	    			strArr[j] = strArr[j+1];
    	    			strArr[j+1] = temp2;
    				}
    				else
    				{break;}
    			}
    		}
    	}

    }
}
