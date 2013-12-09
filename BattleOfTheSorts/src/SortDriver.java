import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class SortDriver {
	private static int numKeys = 0;
	private static String[] dataArr;
	
	public static void main(String[] args){
		long start = 0;
		long end = 0;
		long time = 0;
		String fileName = args[0];

		//find how many keys
		//assumes # of keys is after - and before second . in fileName
		int delim1 = fileName.indexOf('-');
		int delim2 = fileName.substring(1).indexOf('.');
		numKeys = Integer.parseInt(fileName.substring(delim1+1, delim2+1));


		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Sort Test: " + args[0]);
		
		//sort using heap sort
		parseData(fileName);
		start = System.nanoTime();
		HeapSort.heapSort(dataArr);
		end = System.nanoTime();
		time = end - start;
		System.out.printf("%-32s %32s %32s %32s\n","Heap Sort:",time+" ns;", "First Key: " + dataArr[0] + ";", "Last Key: " + dataArr[dataArr.length-1]);
		
		//sort using insertion sort
		parseData(fileName);
		start = System.nanoTime();
		InsertionSort.insertionSort(dataArr);
		end = System.nanoTime();
		time = end - start;
		System.out.printf("%-32s %32s %32s %32s\n","Insertion Sort:",time+" ns;", "First Key: " + dataArr[0] + ";", "Last Key: " + dataArr[dataArr.length-1]);
		
		//sort using merge sort
		parseData(fileName);
		start = System.nanoTime();
		MergeSort.mergeSort(dataArr);
		end = System.nanoTime();
		time = end - start;
		System.out.printf("%-32s %32s %32s %32s\n","Merge Sort:",time+" ns;", "First Key: " + dataArr[0] + ";", "Last Key: " + dataArr[dataArr.length-1]);
		
		//sort using quick sort
		parseData(fileName);
		start = System.nanoTime();
		QuickSort.quickSort(dataArr);
		end = System.nanoTime();
		time = end - start;
		System.out.printf("%-32s %32s %32s %32s\n","Quick Sort:",time+" ns;", "First Key: " + dataArr[0] + ";", "Last Key: " + dataArr[dataArr.length-1]);
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");

	}
	
	public static void parseData(String fileName){
		//takes in an input file of Strings delimited by newline
		//reads file into an array
		//DATA ASSUMED TO HAVE ONLY STRINGS!!!!		
		File file = new File(fileName);
		BufferedReader fileIn = null;

		//initialize array based on number of keys to dereference it
		dataArr = new String[numKeys];
		
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
	}
}
