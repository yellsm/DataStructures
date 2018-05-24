import java.util.Arrays;

public class TheStack {
	private String[] stackArray;
	private int stackSize;
	private int topOfStack = -1;
	
	TheStack(int size){
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}
	
	public void push(String input) {
		if(topOfStack + 1 < stackSize) {
			topOfStack++;
			stackArray[topOfStack] = input;
		}else System.out.println("Sorry, the stack is full!");
		displayTheStack();
		System.out.println("PUSH " + input + " Was Added to the Stack\n");
	}
	
	
	public void displayTheStack(){
		for(int n = 0; n < 61; n++)System.out.print("-");
		System.out.println();
		for(int n = 0; n < stackSize; n++){
			System.out.format("| %2s "+ " ", n);
			}
		System.out.println("|");
		for(int n = 0; n < 61; n++)System.out.print("-");
		System.out.println();
		for(int n = 0; n < stackSize; n++){
			if(stackArray[n].equals("-1")) System.out.print("|     ");
			else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
			}
		System.out.println("|");
		for(int n = 0; n < 61; n++)System.out.print("-");
		System.out.println();
	}

	public String pop() {
		if(topOfStack >= 0) {
			displayTheStack();
			System.out.println("Pop " + stackArray[topOfStack] + " was removed!\n");
			stackArray[topOfStack] = "-1";
			displayTheStack();
			return stackArray[topOfStack--];
		}else {
			displayTheStack();
			System.out.println("Sorry, the stack is empty!");
			return "-1";
		}
	}
	
	public String peek() {
		displayTheStack();
		System.out.println(" " + stackArray[topOfStack] +" is at the top.");
		return stackArray[topOfStack];
	}
	
	//pushMany("11 21 76 22 32 26");
	public void pushMany(String many) {
		 String[] tempString = many.split(" ");
		 for(int i = 0; i < tempString.length; i++){
			 push(tempString[i]);
		 }
	}
	
	public void popAll() {
		for(int i = topOfStack;i >= 0; i--) {
			pop();
		}
	}
	
	public static void main(String[] args) {
		TheStack newStack = new TheStack(10);
		newStack.push("20");
		newStack.push("22");
		newStack.push("27");
		newStack.push("29");
		newStack.pushMany("11 21 76 22 32 26");
		
	}
}
