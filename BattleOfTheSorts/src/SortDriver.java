import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SortDriver {
	public static void main(String[] args){
		String [] testArr;
		String [] dataArr;
		long start = 0;
		long end = 0;
		long time = 0;
		
		//takes in an input file of Strings delimited by newline
		//reads file into an array
		//DATA ASSUMED TO HAVE ONLY STRINGS!!!!		
		File file = new File(args[0]);
		BufferedReader fileIn = null;
		
		//find how many keys
		//assumes # of keys is after - and before second . in fileName
		int delim1 = args[0].indexOf('-');
		int delim2 = args[0].substring(1).indexOf('.');
		int numKeys = Integer.parseInt(args[0].substring(delim1+1, delim2+1));

		//initialize arrays based on number of keys
		dataArr = new String[numKeys];
		testArr = new String[numKeys];
		
		try {
			String currLine;
			fileIn = new BufferedReader(new FileReader(file));
			
			int index = 0;
			while( (currLine = fileIn.readLine()) != null){
				dataArr[index] = currLine;
				index++;
			}
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: Please provide a file with data to test Sorts on.");
		} finally {	
			try{
				fileIn.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}

		
		System.out.println("-----------------------------------------------------------");
		System.out.println("Sort Test: " + args[0]);
		
		//sort using heap sort
		System.out.println("Heap Sort:");
		
		//sort using insertion sort
		System.arraycopy(dataArr, 0, testArr, 0, dataArr.length);
		start = System.nanoTime();
		InsertionSort.insertionSort(testArr);
		end = System.nanoTime();
		time = end - start;
		System.out.printf("%-32s %32s %32s %32s\n","Insertion Sort:",time+" ns;", "First Key: " + testArr[0] + ";", "Last Key: " + testArr[testArr.length-1]);
		
		//sort using merge sort
		System.arraycopy(dataArr, 0, testArr, 0, dataArr.length);
		start = System.nanoTime();
		MergeSort.mergeSort(testArr);
		end = System.nanoTime();
		time = end - start;
		System.out.printf("%-32s %32s %32s %32s\n","Merge Sort:",time+" ns;", "First Key: " + testArr[0] + ";", "Last Key: " + testArr[testArr.length-1]);
		
		//sort using quick sort
		System.arraycopy(dataArr, 0, testArr, 0, dataArr.length);
		start = System.nanoTime();
		QuickSort.quickSort(testArr);
		end = System.nanoTime();
		time = end - start;
		System.out.printf("%-32s %32s %32s %32s\n","Quick Sort:",time+" ns;", "First Key: " + testArr[0] + ";", "Last Key: " + testArr[testArr.length-1]);
	}
}
