//Luis Lopez
//Assignment 3

public class LinkList {
	
	private Link first; // ref to first link on list
	
	public LinkList(){ // constructor
		
		first = null; // no items on list yet
	
	}
	
	public boolean isEmpty() { // true if list is empty
	
		return (first == null);
	
	}
	
	
	// insert at start of list
	public void insertFirst(char id) {
		
	 // make new link
		Link newLink = new Link(id);
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	
	}
	public void insertFirst(int id) {
		
		 // make new link
			Link newLink = new Link(id);
			newLink.next = first; // newLink --> old first
			first = newLink; // first --> newLink
		
		}
	
	public Link deleteFirst() { // delete first item
		
		// (assumes list not empty)
		Link temp = first; // save reference to link
		first = first.next; // delete it: first-->old next
		return temp; // return deleted link
	
	}
	
	public void displayList(){
		
		System.out.print("List (first --> last): ");
		Link current = first; //current is a walker starts pointing at first link
		while(current != null) {//loops until current points at the last link
		
			current.displayLink();
			current = current.next;
		
		}
		
		System.out.println();
	
	}
public void displayListInt(){
		
		System.out.print("List (first --> last): ");
		Link current = first; //current is a walker starts pointing at first link
		while(current != null) {//loops until current points at the last link
		
			current.displayLinkInt();
			current = current.next;
		
		}
		
		System.out.println();
	
	}
	
	public Link find(char key) {//find a link with given key assuming non-empty list
		
		Link current = first;// starts at the beginning of list
		
		while(current.cData != key) {//loops if there is no match
			
			if(current.next == null)// if last link's next is null then we did not find the key
				return null;
			else
				current = current.next;// go to next link
			
		}
		
		return current; //we found the key. this line will ONLY execute if the key was found
		
	}
	
	public Link delete(char key) {//delete link with given key
		
		Link current = first;
		Link previous = first;
		
		while(current.cData != key) {
			
			if(current.next == null)
				return null; //we did not find key
			else {
				
				previous = current; //previous now pointing to where current was
				current = current.next; //and current is now pointing to the next link
				
			}
				
		}
		
		//below will execute if key was found!
		
		if(current == first) //if key is first link
			first = first.next; //delete first link by first pointing at the second link
		else
			previous.next = current.next;//if key is not the first link, bypass it. previous.next will now point where current.next was, thus "deleting" the link where current is pointing at.
		
		return current;
		
	}
	
	//Old find RM method
	/*
	public boolean findRMndel(LinkList templist) {
		
		Link previous, current;
		
		previous = templist.find('r');
		current = templist.find('m');
		
		
		
		
		if((previous.next == current) && current.next == null) {//if 'rm' is at the end of the list, delete those two characters.
			
			templist.delete(previous.cData);
			templist.delete(current.cData);
			
			
			return true;
			
		}
		else if((previous.next == current) && current.next != null) {//if 'rm' is found, remove the following character after 'rm'
			
			templist.delete(current.next.cData);
			templist.delete(previous.cData);
			templist.delete(current.cData);
			
			return true;
			
		}
		
		
		return false;
		

	}
	*/
	
public boolean findRM(LinkList templist) {
	
	Link previous, current, middle;
	boolean tempbool = false;
	//Walkers 
	previous = templist.first; //backup
	middle = templist.first;// holds 'r'
	current = templist.first.next;//holds 'm'
	
	while(current != null) {//loops until currentConso points at the last link

		if(middle.cData == 'r' && current.cData == 'm') {
			
			//previous = current.next.next;
			
			templist.delete(middle.cData);
			templist.delete(current.cData);
			templist.delete(current.next.cData);
			
			previous = middle; //previous now pointing to where middle was
			middle = middle.next; //and middle is now pointing to where current was
			//current = current.next;// then current is now pointing to next link
			tempbool = true;
			return tempbool;
			
		}
		else{
			
			previous = middle; //previous now pointing to where middle was
			middle = middle.next; //and middle is now pointing to where current was
			current = current.next;// then current is now pointing to next link
		}
		
		
	
	}
	
	//I could not figure out how to delete 'rm' if it appeared at the end of the list unforunately.
	
	
	//if( (middle.cData == 'r' && current.cData == 'm') && current.next == null) {
		
		//templist.delete(middle.cData);
		//templist.delete(current.cData);
		//templist.delete(current.next.cData);
		
		//previous = current.next.next;
		//tempbool = true;
		//return tempbool;
	//}
	
	return tempbool;
	
}
	
	
public boolean findVowelBConst(LinkList templist) {
		
		Link previousConso, currentConso, middleVowel;
		boolean tempbool = false;
		//Walkers 
		previousConso = templist.first; //left consonant
		middleVowel = templist.first.next;// middle vowel
		currentConso = templist.first.next.next;//right consonant
		
		
		while(currentConso != null) {//loops until currentConso points at the last link
			
			
			if( (templist.checkVowelorConsonant(previousConso.cData) == false) && (templist.checkVowelorConsonant(middleVowel.cData) == true) && (templist.checkVowelorConsonant(currentConso.cData) == false) ) {
				
				
				templist.delete(middleVowel.cData);
				
				tempbool = true;
				return tempbool;
				
			}
			else {
				
				previousConso = previousConso.next;
				middleVowel = middleVowel.next;
				currentConso = currentConso.next;
				
			}

		}
		
		
		
		return tempbool;
		
	}


public boolean checkVowelorConsonant (char letter) {
	
	//true for vowel
	//false for consonant
	
	char tempChar = letter;
	
	if(tempChar == 'a' || tempChar == 'e' || tempChar == 'i' || tempChar == 'o' || tempChar == 'u') {
		
		return true;
		
	}
	else {
		
		return false;
		
	}
	
	
	

	}



public LinkList merge2(LinkList list1, LinkList list2) {
	
	Link currentP = list1.first;
	Link currentQ = list2.first;
	LinkList tempOrderedList = new LinkList();
	Link currentSorting = null;
	
	if(currentP == null)
		return list2;
	if(currentQ == null)
		return list1;
	
	if(currentP != null && currentQ != null) {
		
		if(currentP.iData <= currentQ.iData) {
			
			currentSorting = currentP;
			currentP = currentP.next;
		}
		else{
			
			currentSorting = currentQ;
			currentQ = currentQ.next;
			
		}	
	}
	
	tempOrderedList.first = currentSorting;
	
	while(currentP != null && currentQ != null) {
		
		if(currentP.iData <= currentQ.iData) {
			
			currentSorting.next = currentP;
			currentSorting = currentP;
			currentP = currentSorting.next;
			
		}
		else {
			
			currentSorting.next = currentQ;
			currentSorting = currentQ;
			currentQ = currentSorting.next;
			
		}
		
	}
	
	if(currentP == null) {
		
		currentSorting.next = currentQ;
		
	}
	if(currentQ == null) {
		
		currentSorting.next = currentP;
		
	}
	

	return tempOrderedList;
}


public int countDuplicates(int searchNum) {
	
	int count = 0;
	Link current = first;
	
	while(current != null){
		
		if(current.iData == searchNum) {
			
			count++;
			
		}
		
		current = current.next;
		
	}
	
	
			
		return count;
	}

public void printDuplicates(LinkList mergedlist) {
	
	Link current = first;
	
	while(current != null) {//loops until current points at the last link
		
		
		if(mergedlist.countDuplicates(current.iData) > 1) {
			
			for(int i = 0; i < mergedlist.countDuplicates(current.iData); i++) {
				
				System.out.printf("%d ", current.iData);
				
			}
			
		}
		
		
		System.out.println("\n");
		current = current.next;
		
	}
	
}


}
