/*
 *  array 
 *  bubble sort, selection sort, insertion sort
 *  
 */
public class ArrayStructures {
	
	private int[] theArray = new int[50];
	
	private int arraySize = 10;
	
	public void generateRandomArray() {	
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int)(Math.random()*10) + 10;
		}
	}
	
	//vertically print array
	public void printArray() {
		System.out.println("-------");
		for(int i = 0;i < arraySize; i++) {
			System.out.print(i + " | ");
			System.out.println(theArray[i]);
			System.out.println("-------");
		}
	}
	

	public void printHorzArray(int i, int j){
		for(int n = 0; n < 51; n++)System.out.print("-");
		System.out.println();
		for(int n = 0; n < arraySize; n++){
			System.out.print("| " + n + "  ");
			}
		System.out.println("|");
		for(int n = 0; n < 51; n++)System.out.print("-");
		System.out.println();
		for(int n = 0; n < arraySize; n++){
			System.out.print("| " + theArray[n] + " ");
			}
		System.out.println("|");
		for(int n = 0; n < 51; n++)System.out.print("-");
		System.out.println();
		// END OF FIRST PART
		// ADDED FOR BUBBLE SORT
		if(j != -1){
			// ADD THE +2 TO FIX SPACING
			for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
			System.out.print(j);
			}
		// THEN ADD THIS CODE
		if(i != -1){
			// ADD THE -1 TO FIX SPACING
			for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
			System.out.print(i);
			}
		System.out.println();
	    }

	
	public int getValueAtIndex(int index) {
		if(index < arraySize) return theArray[index];
		
		return 0;
	}
	
	public boolean doesArrayContainValue(int value) {
		boolean containValue = false;
		
		for(int i = 0;i < arraySize;i++) {
			if(theArray[i] == value) containValue = true;
		}		
		return containValue;
	}
	
	public void deleteIndex(int index) {
		if(index < arraySize) {
			for(int i = index;i < (arraySize - 1); i++) {
				theArray[i] = theArray[i + 1];
			}
			arraySize --;
		}
	}
	
	//insert a value at the end of an array
	public void insertValue(int value) {
		if(arraySize < 50) {
			theArray[arraySize] = value;
			arraySize++;
			}
	}
	
	//return the index for the given value
	public String linearSearchForValue(int value) {
		boolean valueInArray = false;
		String indexsWithValue = "";
		
		System.out.print(value + " was found in the following indexs: ");
		for(int i = 0;i < arraySize;i++) {
			if(theArray[i] == value) {
				valueInArray = true;
				indexsWithValue = i + " ";
				System.out.print(i + " ");
			}
		}
		//if the value is not in the array
		if(!valueInArray) {
			indexsWithValue =  value + " is not in the array";
			System.out.print(indexsWithValue);
		}

		return indexsWithValue;
	}

	//O(n^2) compare and swap two adjacent values
	public void bubbleSort() {
		for(int i = arraySize - 1;i > 1;i--) {
			for(int j = 0;j < i;j++) {
				if(theArray[j] > theArray[j+1]) {
					swapValues(j,j+1);
					printHorzArray(i,j);
				}
			}
		}
	}
	
	//find the minimum and out it at the beginning
	public void selectionSort() {
		for(int i = 0;i < arraySize;i++) {
			int minimum = i;
			for(int j = i;j < arraySize;j++) {
				if(theArray[minimum] > theArray[j+1]) {
					minimum = j+1;
				}
			}
			swapValues(i,minimum);
			printHorzArray(i,-1);
		}
	}
	
	public void insertionSort() {
		for(int i = 0;i < arraySize;i++) {
			int j = i;	//check and move variable to be sorted
			int key = theArray[i];
			
			while(j > 0 && theArray[j-1] > key ) {	//put key into the correct position
				theArray[j] = theArray[j - 1];
				j--;
				printHorzArray(i,j);
			}
			
			theArray[j] = key;
			printHorzArray(i,j);
			System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " 
			+ theArray[j] + " toInsert = " + key + "\n");
		}
	}
	
	//find the index of value if the array is already sorted
	public void binarySearchForValue(int num) {
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		
		while(lowIndex <= highIndex) {
			int middleIndex = (highIndex - lowIndex)/2;
			
			if(theArray[middleIndex] < num) {
				lowIndex = middleIndex + 1;
			}else if(theArray[middleIndex] > num) {
				highIndex = middleIndex - 1;
			}else {
				System.out.println("Found " + num + " in index "+ middleIndex);
				lowIndex = highIndex + 1; //jump out the loop
			}
			//printHorzArray(middleIndex,-1);
		}
	}
	
	//swap the values in the two given index
	public void swapValues(int indexOne,int indexTwo) {
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
	}
	
	public static void main(String[] args) {
		ArrayStructures newArray = new ArrayStructures();
		newArray.generateRandomArray();
		newArray.insertionSort();;
		newArray.binarySearchForValue(11);
		newArray.linearSearchForValue(11);
	}
}
