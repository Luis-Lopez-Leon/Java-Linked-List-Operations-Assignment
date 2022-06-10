//Luis Lopez
//Assignment 3

public class Link {
	
	//change these int and double to whatever my program needs
	public char cData;    //data item (key)
	public int iData;
	public Link next;    //next link in list
	
	public Link(char id) { //constructor
		
		cData = id; //initialize data
		 
		next = null; //I set it to null for clarity. ('next' is automatically set to null if not initialized)
		
	}
	public Link(int id) { //constructor
		
		iData = id; //initialize data
		 
		next = null; //I set it to null for clarity. ('next' is automatically set to null if not initialized)
		
	}
	
	public void displayLink() {
		
		System.out.print("{" + cData + "} ");
		
	}
	public void displayLinkInt() {
		
		System.out.print("{" + iData + "} ");
		
	}
	
	
	

}
