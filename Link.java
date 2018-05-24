
public class Link {
	public String bookName;
	public int millionSold;
	public Link next;
	
	public Link(String bookName, int millionSold) {
		this.bookName = bookName;
		this.millionSold = millionSold;
	}
	
	public void display() {
		System.out.print(bookName + ": " + millionSold + ",000,000");
	}
	
	public String toString() {
		return bookName;
	}
	
	public static void main(String[] args) {
		
	}
}

class LinkList{
	public Link firstLink;
	
	LinkList(){
		firstLink = null;	//the first link start with null value
	}
	
	public boolean isEmpty() {
		return(firstLink == null);
	}
	
	public void insertFirstLink(String bookName, int millionSold) {
		Link newLink = new Link(bookName,millionSold);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public Link removeFirst() {
		Link linkListReference = firstLink;
		if(!isEmpty()) {
			firstLink = firstLink.next;
		}else {
			System.out.println("the link list is empty.");
		}
		return linkListReference;
	}
	
	public void display() {
		Link theLink = firstLink;
		  while(theLink != null){
			  theLink.display();
			  System.out.println("Next Link: " + theLink.next);
			  theLink = theLink.next;
			  System.out.println();
		}
	}
	
	public Link find(String bookName) {
		Link theLink = firstLink;
		if(!isEmpty()) {
			while(theLink.bookName != bookName) {
				if(theLink.next == null) {
					return null;
				}else {
					theLink = theLink.next;
				}
			}
		}else {
			System.out.println("Empty link list!");
		}
		return theLink;
	}
	
	public Link removeLink(String bookName){
		Link currentLink = firstLink;
		Link previousLink = firstLink;
		// Keep searching as long as a match isn't made
		while(currentLink.bookName != bookName){
			// Check if at the last Link in the LinkedList
			if(currentLink.next == null){
				// bookName not found so leave the method
				return null;
				} else {
					// We checked here so let's look in the
		                // next Link on the list
		                previousLink = currentLink;
		                currentLink = currentLink.next;
		                }
		        }
		        if(currentLink == firstLink){
		
		            // If you are here that means there was a match
		            // in the reference stored in firstLink in the
		            // LinkedList so just assign next to firstLink
		
		            firstLink = firstLink.next;
		             
		        } else {
		            // If you are here there was a match in a Link other
		            // than the firstLink. Assign the value of next for
		            // the Link you want to delete to the Link that's
		            // next previously pointed to the reference to remove
		            System.out.println("FOUND A MATCH");
		            System.out.println("currentLink: " + currentLink);
		            System.out.println("firstLink: " + firstLink);
		            previousLink.next = currentLink.next;
		        }
		        return currentLink;
		    }

	
	
	
}
