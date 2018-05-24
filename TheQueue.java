import java.util.Arrays;

public class TheQueue {
	
	private String[] queueArray;
	private int queueSize;
	private int front, end, numOfItems = 0;
	
	TheQueue(int size){
		queueSize = size;
		queueArray = new String[size];
		Arrays.fill(queueArray, "-1");
	}
	
	public void insert(String input) {
		if(numOfItems + 1 <= queueSize) {
			queueArray[end] = input;
			end++;
			numOfItems++;
			System.out.println("Insert "+ input);
		}else {
			System.out.println("Sorry, the queue is full.");
		}
	}
	
	public void priorityInsert(String input) {
		int i = 0;
		if(numOfItems == 0) {
			insert(input);
		}else {
			for(i = numOfItems - 1;i >= 0;i--) {
				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {
					queueArray[i+1] = queueArray[i];
				}else break;
			}
		}
		
		queueArray[i+1] = input;
		end++;
		numOfItems++;
	}
	
	public void remove() {
		if(numOfItems <= 0) {
			System.out.println("Sorry, the queue is empty.");
		}else {
			System.out.println("Front "+ queueArray[front] + " was removed!");
			queueArray[front] = "-1";
			numOfItems--;
			front++;
		}
	}
	
	public void peek() {
		System.out.println("The first element is "+ queueArray[front]);
	}
	
	public void displayTheQueue(){
		for(int n = 0; n < 61; n++)System.out.print("-");
		System.out.println();
		for(int n = 0; n < queueSize; n++){
			System.out.format("| %2s "+ " ", n);
			}
		System.out.println("|");
		for(int n = 0; n < 61; n++)System.out.print("-");
		System.out.println();
		for(int n = 0; n < queueSize; n++){
			if(queueArray[n].equals("-1")) System.out.print("|     ");
			else System.out.print(String.format("| %2s "+ " ", queueArray[n]));
			}
		System.out.println("|");
		for(int n = 0; n < 61; n++)System.out.print("-");
		System.out.println();
		// Number of spaces to put before the F
		int spacesBeforeFront = 3*(2*(front+1)-1);
		for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");
		System.out.print("F");
		// Number of spaces to put before the R
		int spacesBeforeRear = (2*(3*end)-1) - (spacesBeforeFront);
		for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");
		System.out.print("R");
		System.out.println("\n");
	}

	
	public static void main(String[] args) {
		TheQueue newQueue = new TheQueue(10);
		//newQueue.insert("10");
		//newQueue.insert("12");
		//newQueue.insert("17");
		newQueue.priorityInsert("3");
		newQueue.priorityInsert("5");
		newQueue.priorityInsert("77");
		newQueue.priorityInsert("24");
		newQueue.priorityInsert("66");

		newQueue.remove();
		newQueue.peek();
		newQueue.displayTheQueue();
		
	}
}
